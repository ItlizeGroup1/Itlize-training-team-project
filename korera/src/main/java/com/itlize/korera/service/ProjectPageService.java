package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectPage;

import java.util.List;

public interface ProjectPageService {
    List<ProjectPage> getProjects();
    String deleteProjectById(Integer id);
    String createProject(Integer Pcode,String Pname);
    String updateProject(Integer pid,Integer pcode,String pname);
}
