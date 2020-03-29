package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;

import java.util.List;

public interface ResourceDetailsService {
    String create(Integer rid, String columnName, String columnValue);
    String deleteCol(String columnName);
    String update(Integer rdid, String columnValue);
    List<ResourceDetails> getAll();
}
