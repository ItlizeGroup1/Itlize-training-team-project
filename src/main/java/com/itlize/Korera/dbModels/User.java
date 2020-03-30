package com.itlize.Korera.dbModels;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


@PropertySource(value = {"classpath:users.properties"})
@Component
@ConfigurationProperties(prefix = "user")
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @CreatedDate
    private Date timeCreat;

    @LastModifiedDate
    private Date lastUpdated;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    private String title;

    @Transient
    private String token;

    @OneToMany(targetEntity = Project.class,cascade = CascadeType.REMOVE,mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Project> projects = new HashSet<Project>();

    public Collection<Project> getProjects() {
        return projects;
    }

    public void addProjects(Project project){
        if(projects.contains(project)){
            return ;
        }
        projects.add(project);
        project.setOwner(this);
    }
    public void removeProjects(Project project){
        if(!projects.contains(project)){
            return ;
        }
        projects.remove(project);
        project.setOwner(null);
    }

    public User() {
    }

    public User(String username, String password, String title) {
        this.username = username;
        this.password = password;
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTimeCreat() {
        return timeCreat;
    }

    public void setTimeCreat(Date timeCreat) {
        this.timeCreat = timeCreat;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
