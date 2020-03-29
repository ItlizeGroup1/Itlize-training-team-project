package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Resource;

import java.util.List;

public interface ResourceService {
    String create(Integer rCode, String resourceName);
    String delete(Integer rid);
    List<Resource> getAll();
    String updateByRid(Integer rid,Integer rCode, String resourceName);
}
