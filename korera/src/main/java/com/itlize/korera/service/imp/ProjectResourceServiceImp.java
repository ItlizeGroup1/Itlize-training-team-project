package com.itlize.korera.service.imp;

import com.itlize.korera.entity.ProjectPage;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.ProjectUser;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectResourceServiceImp implements ProjectResourceService {

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public List<ProjectResource> getProjectResourceByPid(Integer Pid){
        return projectResourceRepository.findAllByPid(Pid);
    }

    @Override
    public String deleteProjectResource(Integer prid){
        projectResourceRepository.deleteById(prid);
        return "ProjectResource has been deleted";
    }

    @Override
    public String deleteWholeProject(Integer pid){
        projectResourceRepository.deleteAllByPid(pid);
        return "Project has been deleted";
    }

    @Override
    public String addProjectResource(Integer Pid,Integer Rid){
        ProjectResource pr= new ProjectResource();
        pr.setPid(Pid);
        pr.setRid(Rid);
        projectResourceRepository.save(pr);
        return "ProjectResource has been added";
    }

    @Override
    public  String updateProjectResource(Integer prid, Integer rid){
        Optional<ProjectResource> optional = projectResourceRepository.findById(prid);
        if (optional.isPresent()){
            ProjectResource p = optional.get();
            p.setRid(rid);
            projectResourceRepository.save(p);
            return "ProjectResource has been updated!";
        }
        return "ProjectResource Is Not Found!";
    }
}