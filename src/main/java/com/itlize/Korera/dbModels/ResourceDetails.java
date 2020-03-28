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

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Resource.class,cascade = CascadeType.ALL)
    private Resource resource;

    @ManyToOne(targetEntity = Columns.class, cascade = CascadeType.ALL)
    private Columns column;

    private String columnValue;

    public ResourceDetails() {
    }

    public ResourceDetails(String columnValue) {
        this.columnValue = columnValue;
    }

    @Override
    public String toString() {
        return "ResourceDetails{" +
                "resource=" + resource +
                ", column=" + column +
                ", columnValue='" + columnValue + '\'' +
                '}';
    }

    public String toEntry(){
        return String.format("\"%s\" : \"%s\"",column.getColumnName(),columnValue);
    }


    public Columns getColumn() {
        return column;
    }

    public void setColumn(Columns column) {
        this.column = column;
    }

    public String getColumnValue() {
        return columnValue;
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



    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }
}
