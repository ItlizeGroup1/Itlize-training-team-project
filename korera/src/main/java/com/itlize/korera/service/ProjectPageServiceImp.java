package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectPage;
import com.itlize.korera.repository.ProjectPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPageServiceImp implements ProjectPageService {

    @Autowired ProjectPageRepository projectPageRepository;

    @Override
    public String createProject(Integer Pcode, String Pname) {
        ProjectPage pp= new ProjectPage();
        pp.setPcode(Pcode);
        pp.setPname(Pname);
        projectPageRepository.save(pp);
        return "saved";
    }

    @Override
    public List<ProjectPage> getProjectById(Integer id) {
        return projectPageRepository.findAll();
    }
    @Override
    public String deleteProjectById( Integer id) {
        projectPageRepository.deleteById(id);
        return "deleted";
    }
}
