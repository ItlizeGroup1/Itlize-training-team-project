package com.itlize.korera.service;


import com.itlize.korera.entity.ResourceColumns;

public interface ResourceColumnsService {
    public boolean create(ResourceColumns resourceColumns);
    public boolean delete(ResourceColumns resourceColumns);
    public boolean update(String columnName, String newColumnName);
    public ResourceColumns get(String columnName);
}