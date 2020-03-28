package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public String create(Integer id, String projectName, String uid) ;
    public boolean deleteProjectById(Integer id);
    public String update(Integer pid, String projectName, String uid);
    public List<Project> readAll();
    public Optional<Project> readById(Integer id);

}
