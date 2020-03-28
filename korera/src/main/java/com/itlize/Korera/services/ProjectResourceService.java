package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectResource;
import com.itlize.Korera.dbModels.Resource;

import java.util.List;

public interface ProjectResourceService {
    String create(Integer pid,Integer rid);
    List<ProjectResource> readByProject(Integer pid);
    String update(Integer prid, Integer rid);
    String delete(Integer prid);

}
