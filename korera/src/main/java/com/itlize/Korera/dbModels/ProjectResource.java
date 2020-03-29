package com.itlize.Korera.dbModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    private Project projectId;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.DETACH)
    private Resource resourceId;

    public ProjectResource() {
    }
    public ProjectResource(Project projectId, Resource resourceId) {
        this.projectId = projectId;
        this.resourceId = resourceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }


}
