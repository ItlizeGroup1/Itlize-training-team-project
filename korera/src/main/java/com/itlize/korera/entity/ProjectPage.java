package com.itlize.korera.entity;

import javax.persistence.*;

@Entity

public class ProjectPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Pid;
    private Integer Pcode;
    private String Pname;

    public ProjectPage() {
    }

    public Integer getPid() {
        return Pid;
    }

    public Integer getPcode() {
        return Pcode;
    }

    public void setPcode(Integer pcode) {
        Pcode = pcode;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }
}