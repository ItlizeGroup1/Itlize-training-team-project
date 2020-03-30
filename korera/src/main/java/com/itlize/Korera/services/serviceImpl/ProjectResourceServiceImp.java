package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectResource;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.repositories.ProjectResourceRepository;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Resource> readByProject(Integer pid){
        Optional<Project> optional = projectRepository.findById(pid);
        if(optional.isPresent()){
            Project p=optional.get();
            List<Resource> list = new ArrayList<>();
            for (ProjectResource i:projectResourceRepository.findAllByProjectId(p)) {
                list.add(i.getResourceId());
            }
            return list;
        }else return null;
    }
    public String update(Integer prid, Integer rid){
        Optional<ProjectResource> op1 = projectResourceRepository.findById(prid);
        Optional<Resource> op3 = resourceRepository.findById(rid);

        if(op1.isPresent()&op3.isPresent()){
            ProjectResource pr = op1.get();
            pr.setResourceId(op3.get());
            projectResourceRepository.save(pr);
            return prid+ " :Resource {"+rid+"} has been updated successfully!";
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
