package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.ProjectUser;
import com.itlize.korera.repository.ProjectResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {
    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public List<ProjectUser> getProjectResourceByPid(Integer Pid){
        return projectResourceRepository.findAllByPid(Pid);
    }

    @Override
    public String deleteProjectResource(Integer id){
        projectResourceRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public String addProjectResource(Integer Pid,Integer Rid){
        ProjectResource pr= new ProjectResource();
        pr.setPid(Pid);
        pr.setRid(Rid);
        projectResourceRepository.save(pr);
        return "added";
    }


}
