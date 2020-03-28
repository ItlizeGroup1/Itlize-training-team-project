package com.itlize.Korera.dbModels;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ProjectColumns {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date timeCreated;
    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.ALL)
    private Project projectId;

    private String columnName;

    @Enumerated(EnumType.STRING)
    private ProjectColumnEnum type;

    private String formula;

    public ProjectColumns(Project projectId, String columnName, ProjectColumnEnum type, String formula) {
        this.projectId = projectId;
        this.columnName = columnName;
        this.type = type;
        this.formula = formula;
    }

    public ProjectColumns() {
    }

    public ProjectColumns(Project projectId, String columnName) {
        this.projectId = projectId;
        this.columnName = columnName;
    }

    public ProjectColumnEnum getType() {
        return type;
    }

    public void setType(ProjectColumnEnum type) {
        this.type = type;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
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

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
