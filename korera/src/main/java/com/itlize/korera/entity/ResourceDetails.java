package com.itlize.korera.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ResourceDetails {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Resource1.class,cascade = CascadeType.ALL)
    private Resource1 resourceId;

    private String columnName;
    private String columnValue;

    public ResourceDetails(Resource1 resourceId, String columnName, String columnValue) {
        this.resourceId = resourceId;
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public ResourceDetails(){};

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

    public Resource1 getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource1 resourceId) {
        this.resourceId = resourceId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }
}
