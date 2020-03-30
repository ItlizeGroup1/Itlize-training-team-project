package com.itlize.Korera.dbModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResourceColumns {
    @Id
    @GeneratedValue
    private Integer id;
    String colName;

    public ResourceColumns() {
    }
    public ResourceColumns(String colName) {
        this.colName=colName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }
}
