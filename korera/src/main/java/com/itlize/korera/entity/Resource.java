package com.itlize.korera.entity;

import javax.persistence.*;

@Entity
@Table(name = "Resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private int rid;
    @Column(name = "rcode")
    private String rcode;

    @Column(name = "r_name")
    private String r_name;

    public Resource() {
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }
}
