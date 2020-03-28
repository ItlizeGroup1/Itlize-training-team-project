package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Resource;

public interface ResourceService {
    public boolean create(Resource resource);
    public boolean delete(Resource resource);
    public Resource get(Integer id);
}
