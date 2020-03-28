package com.itlize.korera.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = User2.class,cascade= CascadeType.ALL)
    private User2 owner;
    private String projectName;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @OneToMany(targetEntity = ProjectColumns.class,mappedBy = "projectId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectColumns> columns = new HashSet<ProjectColumns>();

    @OneToMany(targetEntity = ProjectToResource.class, mappedBy = "projectId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectToResource> resources = new HashSet<ProjectToResource>();

    public Collection<ProjectToResource> getResources() {
        return resources;
    }

    public void addProjectToResource(ProjectToResource vResource){
        if(resources.contains(vResource)){
            return ;
        }
        resources.add(vResource);
        vResource.setProjectId(this);
    }

    public void removeProjectToResource(ProjectToResource vResource){
        if(!resources.contains(vResource)){
            return ;
        }
        resources.remove(vResource);
        vResource.setProjectId(null);
    }

    public Collection<ProjectColumns> getColumns() {
        return columns;
    }

    public void addProjectColumns(ProjectColumns column){
        if(columns.contains(column)){
            return ;
        }
        columns.add(column);
        column.setProjectId(this);
    }

    public void removeProjectColumns(ProjectColumns column){
        if(!columns.contains(column)){
            return ;
        }
        columns.remove(column);
        column.setProjectId(null);
    }

    public Project() {
    }

    public Project(User2 owner, String projectName) {
        this.owner = owner;
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User2 getOwner() {
        return owner;
    }

    public void setOwner(User2 owner) {
        this.owner = owner;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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