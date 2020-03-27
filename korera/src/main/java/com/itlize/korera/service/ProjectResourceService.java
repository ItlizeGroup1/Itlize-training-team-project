package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.ProjectUser;

import java.util.List;


public interface ProjectResourceService {
    List<ProjectResource> getProjectResourceByPid(Integer id);
    String deleteProjectResource(Integer prid);
    String addProjectResource(Integer Pid,Integer Rid);
    String updateProjectResource(Integer prid, Integer rid);
    String deleteWholeProject(Integer pid);

}
