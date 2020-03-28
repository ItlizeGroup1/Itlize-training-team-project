package com.itlize.korera.service.imp;

import com.itlize.korera.entity.ProjectPage;
import com.itlize.korera.repository.ProjectPageRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.service.ProjectPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectPageServiceImp implements ProjectPageService {

    @Autowired
    ProjectPageRepository projectPageRepository;

    @Autowired
    ProjectResourceServiceImp projectResourceServiceImp;

    @Override
    public String createProject(Integer Pcode, String Pname) {
        ProjectPage pp= new ProjectPage();
        pp.setPcode(Pcode);
        pp.setPname(Pname);
        projectPageRepository.save(pp);
        return "ProjectPage has been created!";
    }

    @Override
    public List<ProjectPage> getProjects() {
        return projectPageRepository.findAll();
    }

    @Override
    public String deleteProjectById( Integer pid) {
        projectPageRepository.deleteById(pid);
        projectResourceServiceImp.deleteWholeProject(pid);
        return "ProjectPage has been deleted!";
    }

    @Override
    public String updateProject(Integer pid,Integer pcode,String pname){
        Optional<ProjectPage> optional = projectPageRepository.findById(pid);
        if (optional.isPresent()){
            ProjectPage p = optional.get();
            p.setPcode(pcode);
            p.setPname(pname);
            projectPageRepository.save(p);
            return "ProjectPage has been updated!";
        }
        return "Project Is Not Found!";
    }
}