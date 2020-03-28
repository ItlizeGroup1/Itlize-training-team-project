package com.itlize.korera.service;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Project;

public interface ColumnsService {
    public boolean create(Columns column);
    public boolean create(Columns column,Project project);
    public boolean delete(Columns column);
    public boolean update(Columns column, String newColumnName);
    public Columns get(Integer id);
    public Columns get(Project project, String columnName);
}