package com.itlize.Korera.dbModels;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @OneToMany(targetEntity = ProjectResource.class,cascade = CascadeType.DETACH,mappedBy = "resourceId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectResource> projectResources = new HashSet<ProjectResource>();

    @OneToMany(targetEntity = ResourceDetails.class,cascade = CascadeType.PERSIST,mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ResourceDetails> entries = new HashSet<ResourceDetails>();

    @OneToMany(targetEntity = ResourceColumns.class,cascade = CascadeType.DETACH,mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ResourceColumns> columns = new HashSet<ResourceColumns>();

    public Collection<ResourceColumns> getColumns() {
        return columns;
    }

    public void addColumns(ResourceColumns column){
        if(columns.contains(column)){
            return ;
        }
        columns.add(column);
        column.setResource(this);
    }

    public void removeColumns(ResourceColumns column){
        if(!columns.contains(column)){
            return ;
        }
        columns.remove(column);
        column.setResource(null);
    }

    public Collection<ResourceDetails> getEntries() {
        return entries;
    }

    public void addEntries(ResourceDetails entry){
        if(entries.contains(entry)){
            return;
        }
        entries.add(entry);
        entry.setResource(this);
    }
    public void removeEntrie(ResourceDetails entry){
        if(!entries.contains(entry)){
            return;
        }
        entries.remove(entry);
        entry.setResource(null);
    }

    public Collection<ProjectResource> getProjects() {
        return projectResources;
    }

//    public void addProjects(ProjectResource project) {
//        if(projects.contains(project))
//        projects.add(project);
//        project.setResourceId(this);
//    }
//    public void removeProjects(ProjectResource project){
//        if(!projects.contains(project)){
//            return;
//        }
//        projects.remove(project);
//        project.setResourceId(null);
//    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                '}';
    }

    public Resource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
