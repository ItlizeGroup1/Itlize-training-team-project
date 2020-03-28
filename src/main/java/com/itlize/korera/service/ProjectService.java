package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.User2;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public String create(Integer id, String projectName, String uid) ;
    public boolean deleteProjectById(Integer id);
    public String update(Integer pid, String projectName, String uid);
    public List<Project> readAll();
    public Optional<Project> readById(Integer id);
    public boolean create(Project project, User2 user);
    public boolean delete(Project project);
    public Project get(Integer id);
}