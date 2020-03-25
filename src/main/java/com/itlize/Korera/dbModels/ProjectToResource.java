package com.itlize.Korera.dbModels;

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

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.ALL)
    private Project projectId;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.ALL)
    private Resource resourceId;

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

    public ProjectToResource(Project projectId, Resource resourceId) {
        this.projectId = projectId;
        this.resourceId = resourceId;
    }
}
