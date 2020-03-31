package com.itlize.Korera.dbModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {
    @Id
    private String username;

    private String password;
    private String title;
    private Role role;

    @Transient
    private String token;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @OneToMany(targetEntity = Project.class,cascade = CascadeType.REMOVE,mappedBy = "owner")
    @JsonIgnore
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(String username, String title, String passwrod) {
        this.password = passwrod;
        this.username = username;
        this.title = title;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
