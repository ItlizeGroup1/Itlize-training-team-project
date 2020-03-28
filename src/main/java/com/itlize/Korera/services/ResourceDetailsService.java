package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;

import java.util.List;

public interface ResourceDetailsService {
    public boolean create(ResourceDetails resourceDetails, Resource resource) ;
    public boolean delete(ResourceDetails resourceDetails);
    public boolean update(ResourceDetails resourceDetails);
    public boolean update(Resource resource, String columnName, String columnValue);
    public ResourceDetails get(Integer id);
    public ResourceDetails get(Resource resource, String columnName);
    public List<ResourceDetails> get(Resource resource);
    public List<ResourceDetails> get(String columnName);
}
