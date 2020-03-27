package com.itlize.korera.service;

import com.itlize.korera.entity.ProjectUser;
import com.itlize.korera.repository.ProjectUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
 public class ProjectUserServiceImp implements ProjectUserService {
    @Autowired
    ProjectUserRepository projectUserRepository;

    @Override
    public List<ProjectUser>getProjectByUserId(Integer Uid){

        return projectUserRepository.findAllByUid(Uid);
    }
    @Override
    public String addProjectUser(Integer uid, Integer pid){
        ProjectUser pu = new ProjectUser();
        pu.setPid(pid);
        pu.setUid(uid);
        projectUserRepository.save(pu);
        return "projectUser saved";
    }
}
