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
    private Project project;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.ALL)
    private Resource resource;

    @Override
    public String toString() {
        return "ProjectToResource{" +
                "id=" + id +
                ", project=" + project +
                ", resource=" + resource +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"project\":\"" + project +
                "\", \"resource\":\"" + resource +
                "\"}";
    }

    public ProjectToResource() {
    }
    public ProjectToResource(Project projectId, Resource resourceId) {
        this.project = projectId;
        this.resource = resourceId;
    }

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project projectId) {
        this.project = projectId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resourceId) {
        this.resource = resourceId;
    }


}
