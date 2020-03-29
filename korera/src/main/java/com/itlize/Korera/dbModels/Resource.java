package com.itlize.Korera.dbModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer rCode;
    private String resourceName;

    @JsonIgnore
    @OneToMany(targetEntity = ProjectResource.class,cascade = CascadeType.REMOVE,mappedBy = "resourceId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectResource> projects = new HashSet<ProjectResource>();

    @JsonIgnore
    @OneToMany(targetEntity = ResourceDetails.class,cascade = CascadeType.REMOVE,mappedBy = "resource")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ResourceDetails> entries = new HashSet<ResourceDetails>();


    public Resource() {
    }
    public Resource(Integer rCode,String rname){
        this.rCode=rCode;
        resourceName=rname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Collection<ProjectResource> getProjects() {
        return projects;
    }

    public void setProjects(Collection<ProjectResource> projects) {
        this.projects = projects;
    }

    public Collection<ResourceDetails> getEntries() {
        return entries;
    }

    public void setEntries(Collection<ResourceDetails> entries) {
        this.entries = entries;
    }

    public Integer getrCode() {
        return rCode;
    }

    public void setrCode(Integer rCode) {
        this.rCode = rCode;
    }
}
