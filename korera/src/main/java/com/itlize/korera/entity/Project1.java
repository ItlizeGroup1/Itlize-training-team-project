package com.itlize.korera.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Project1 {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = User.class,cascade= CascadeType.ALL)
    private User ower;
    private String projectName;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    public Project1(User ower, String projectName) {
        this.ower = ower;
        this.projectName = projectName;
    }

    public Project1(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwer() {
        return ower;
    }

    public void setOwer(User ower) {
        this.ower = ower;
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
