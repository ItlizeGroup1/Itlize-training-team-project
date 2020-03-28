package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;

import java.util.List;

public interface ProjectResourceService {
    String create(Integer pid,Integer rid);
    List<ProjectResource> readByProject(Integer pid);
    String update(Integer prid, Integer pid, Integer rid);
    String delete(Integer prid);
}