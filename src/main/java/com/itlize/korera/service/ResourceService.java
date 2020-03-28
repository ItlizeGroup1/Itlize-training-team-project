package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;

public interface ResourceService {
    public boolean create(Resource resource);
    public boolean delete(Resource resource);
    public Resource get(Integer id);
}