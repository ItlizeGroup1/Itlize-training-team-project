package com.itlize.korera.entity;

import com.sun.tools.javac.comp.Resolve;
import jdk.internal.instrumentation.TypeMapping;

import javax.persistence.*;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PRid;

    private Integer Pid;

    private Integer Rid;

    public ProjectResource() {
    }

    public Integer getPRid() {
        return PRid;
    }

    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }
}
