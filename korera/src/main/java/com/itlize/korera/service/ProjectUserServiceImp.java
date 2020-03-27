package com.itlize.korera.service;

import com.itlize.korera.repository.ProjectUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
 public class ProjectUserServiceImp implements ProjectUserService {
    @Autowired
    ProjectUserRepository projectUserRepository;

    @Override
    public List<Integer>getProjectByUserId(Integer Uid){
        return projectUserRepository.findAllByUid(Uid);
    };
}
