package com.itlize.korera.entity;


import com.sun.tools.javac.comp.Resolve;
import jdk.internal.instrumentation.TypeMapping;

import javax.persistence.*;

@Entity

public class ProjectResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prid;

    private Integer pid;
    private Integer rid;

    public ProjectResource() {

    }

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}