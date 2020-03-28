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

    @OneToMany(targetEntity = Columns.class,cascade = CascadeType.DETACH,mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Columns> columns = new HashSet<Columns>();

    @OneToMany(targetEntity = ProjectToResource.class, cascade = CascadeType.DETACH, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectToResource> resources = new HashSet<ProjectToResource>();

    public String toJson() {
        return "{" +
                "\"id\" : \"" + id +
                "\", \"projectName\":\"" + projectName + '"' +
                '}';
    }

    public Collection<ProjectToResource> getResources() {
        return resources;
    }

    public void addProjectToResource(ProjectToResource vResource){
        if(resources.contains(vResource)){
            return ;
        }
        resources.add(vResource);
        vResource.setProject(this);
    }

    public void removeProjectToResource(ProjectToResource vResource){
        if(!resources.contains(vResource)){
            return ;
        }
        resources.remove(vResource);
        vResource.setProject(null);
    }

    public Collection<Columns> getColumns() {
        return columns;
    }

    public void addColumns(Columns column){
        if(columns.contains(column)){
            return ;
        }
        columns.add(column);
        column.setProject(this);
    }

    public void removeColumns(Columns column){
        if(!columns.contains(column)){
            return ;
        }
        columns.remove(column);
        column.setProject(null);
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