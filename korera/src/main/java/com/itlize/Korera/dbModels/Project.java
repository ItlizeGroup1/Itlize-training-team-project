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
public class Project {
    @Id
    @GeneratedValue
    private Integer id;

    private String projectName;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    private User owner;

    @OneToMany(targetEntity = ProjectColumns.class,mappedBy = "projectId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectColumns> columns = new HashSet<ProjectColumns>();

    @OneToMany(targetEntity = ProjectResource.class, mappedBy = "projectId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectResource> resources = new HashSet<ProjectResource>();

    public Project() {
    }

    public Project(User owner, String projectName) {
        this.owner = owner;
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
