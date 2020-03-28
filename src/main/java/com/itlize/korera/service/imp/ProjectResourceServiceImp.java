package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public String create(Integer pid,Integer rid){
        Optional<Project> op1 = projectRepository.findById(pid);
        Optional<Resource> op2 = resourceRepository.findById(rid);
        if(op1.isPresent()&&op2.isPresent()){
            ProjectResource pr = new ProjectResource();
            pr.setProjectId(op1.get());
            pr.setResourceId(op2.get());
            projectResourceRepository.save(pr);
            return "Project-Resource{" + pid +"-" +rid+"} has been created successfully!";
        }else return "failed!";
    }

    public List<ProjectResource> readByProject(Integer pid){
        Optional<Project> optional = projectRepository.findById(pid);
        if(optional.isPresent()){
            Project p=optional.get();
            return projectResourceRepository.findAllByProjectId(p);
        }else return null;
    }

    public String update(Integer prid, Integer pid, Integer rid){
        Optional<ProjectResource> op1 = projectResourceRepository.findById(prid);
        Optional<Project> op2 = projectRepository.findById(pid);
        Optional<Resource> op3 = resourceRepository.findById(rid);
        if(op1.isPresent()&&op2.isPresent()&&op3.isPresent()){
            ProjectResource pr = op1.get();
            pr.setProjectId(op2.get());
            pr.setResourceId(op3.get());
            projectResourceRepository.save(pr);
            return prid+ " :Project-Resource {" + pid +"-" +rid+"} has been updated successfully!";
        }else return "failed!";
    }
    public String delete(Integer prid){
        try{
            projectResourceRepository.deleteById(prid);
            return "Project-Resource has been deleted successfully!";
        }catch (Exception e){
            e.getStackTrace();
            return "failed!";
        }
    }
}