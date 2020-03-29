package com.itlize.Korera.dbModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class User {
    @Id
    private String userName;

    @JsonIgnore
    @OneToMany(targetEntity = Project.class,cascade = CascadeType.REMOVE,mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Project> projects = new HashSet<Project>();

    private String title;
    private String password;

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

    public User(String userName, String title, String passwrod) {
        this.password = passwrod;
        this.userName = userName;
        this.title = title;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
