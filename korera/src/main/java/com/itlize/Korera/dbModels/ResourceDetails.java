package com.itlize.Korera.dbModels;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ResourceDetails {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.DETACH)
    private Resource resource;

    private String columnName;
    private String columnValue;

    public ResourceDetails() {
    }

    public ResourceDetails(Resource resource, String columnName, String columnValue) {
        this.resource=resource;
        this.columnName = columnName;
        this.columnValue = columnValue;
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

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
