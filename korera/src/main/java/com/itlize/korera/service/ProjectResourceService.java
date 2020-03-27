package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectUser;

import java.util.List;


public interface ProjectResourceService {
    List<ProjectUser> getProjectResourceByPid(Integer id);
    String deleteProjectResource(Integer id);
    String addProjectResource(Integer Pid,Integer Rid);

}
