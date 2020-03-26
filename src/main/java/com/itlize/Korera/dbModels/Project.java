package com.itlize.Korera.dbModels;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    private User owner;
    private String projectName;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

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

    public User getOwer() {
        return owner;
    }

    public void setOwer(User ower) {
        this.owner = ower;
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
