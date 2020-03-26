package com.itlize.Korera.dbModels;

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

    @ManyToOne(targetEntity = User.class,cascade=CascadeType.ALL)
    private User ower;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.ALL)
    private Project projectId;

    @CreatedDate
    private Date time_created;

    public UserToProject() {
    }

    public UserToProject(User ower, Project projectId) {
        this.ower = ower;
        this.projectId = projectId;
    }

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

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }
}
