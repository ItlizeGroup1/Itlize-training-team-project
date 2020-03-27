package com.itlize.Korera.dbModels;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ResourceColumns {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Resource.class, cascade = CascadeType.ALL)
    private Resource resource;

    private String columnName;

    public ResourceColumns() {
    }

    public ResourceColumns(Resource resource, String columnName) {
        this.resource = resource;
        this.columnName = columnName;
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
