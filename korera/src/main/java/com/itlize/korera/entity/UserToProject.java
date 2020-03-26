package com.itlize.korera.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;


/*
!!NOTICE: If user cannot share project then this table is unnecessary
 */
@Entity
public class UserToProject {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(targetEntity = User2.class,cascade=CascadeType.ALL)
    private User2 ower;

    @ManyToOne(targetEntity = Project1.class,cascade = CascadeType.ALL)
    private Project1 projectId;

    @CreatedDate
    private Date time_created;

    public UserToProject(User2 owner, Project1 projectId) {
        this.ower = ower;
        this.projectId = projectId;
    }

    public UserToProject(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User2 getOwer() {
        return ower;
    }

    public void setOwer(User2 ower) {
        this.ower = ower;
    }

    public Project1 getProjectId() {
        return projectId;
    }

    public void setProjectId(Project1 projectId) {
        this.projectId = projectId;
    }    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }
}
