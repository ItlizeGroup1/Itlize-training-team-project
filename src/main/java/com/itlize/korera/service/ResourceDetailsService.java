package com.itlize.korera.service;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.ResourceDetails;
import java.util.List;

public interface ResourceDetailsService {
    public boolean create(ResourceDetails resourceDetails, Resource resource,Columns column) ;
    public boolean delete(ResourceDetails resourceDetails);
    public boolean update(ResourceDetails resourceDetails);
    public boolean update(Resource resource, Columns column, String columnValue);
    public ResourceDetails get(Integer id);
    public ResourceDetails get(Resource resource, Columns column);
    public List<ResourceDetails> get(Resource resource);
}