package com.itlize.korera.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ProjectToResource {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date time_created;

    @ManyToOne(targetEntity = Project1.class, cascade = CascadeType.ALL)
    private Project1 projectId;

    @ManyToOne(targetEntity = Resource1.class,cascade = CascadeType.ALL)
    private Resource1 resourceId;

    public ProjectToResource(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public Project1 getProjectId() {
        return projectId;
    }

    public void setProjectId(Project1 projectId) {
        this.projectId = projectId;
    }

    public Resource1 getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource1 resourceId) {
        this.resourceId = resourceId;
    }

    public ProjectToResource(Project1 projectId, Resource1 resourceId) {
        this.projectId = projectId;
        this.resourceId = resourceId;
    }
}
