package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.ResourceColumns;

public interface ResourceColumnsService {
    public boolean create(ResourceColumns resourceColumns);
    public boolean delete(ResourceColumns resourceColumns);
    public boolean update(String columnName, String newColumnName);
    public ResourceColumns get(String columnName);
}
