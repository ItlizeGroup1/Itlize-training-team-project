package com.itlize.korera.entity;

import javax.persistence.*;

@Entity
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PUid;

    private Integer Pid;

    private Integer Uid;

    public ProjectUser() {
    }

    public Integer getPUid() {
        return PUid;
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }
}