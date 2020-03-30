package com.itlize.Korera.controller;

import com.itlize.Korera.dbModels.*;
import com.itlize.Korera.repository.ProjectRepository;
import com.itlize.Korera.repository.ProjectToResourceRepository;
import com.itlize.Korera.service.UserService;
import com.itlize.Korera.service.serviceImpl.ProjectToResourceServicelmpl;
import com.itlize.Korera.service.serviceImpl.ProjectServicelmpl;
import com.itlize.Korera.service.serviceImpl.ResourceDetailsServicelmpl;
import com.itlize.Korera.service.serviceImpl.ResourceServicelmpl;
import com.itlize.Korera.service.serviceImpl.UserServiceImpl;
import com.itlize.Korera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/{uid}")
public class projectController {

        @Autowired
        ProjectRepository projectRepository;
        @Autowired
        ProjectServicelmpl projectServiceImpl;
        @Autowired
        ProjectToResourceRepository projectToResourceRepository;
        @Autowired
        ProjectToResourceServicelmpl projectToResourceServiceImp;
//    @Autowired
//    UserRepository userRepository;
        @Autowired
        ResourceServicelmpl resourceServiceImpl;
        @Autowired
       ResourceDetailsServicelmpl resourceDetailsServiceImpl;
        @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * ProjectPage
     */
    //ProjectPage: Add a project
    @PostMapping(path = "/project/projectAdd")
    public boolean createProject(@RequestParam Integer pid,@RequestParam String projectName,@PathVariable String uid){
        User user=userServiceImpl.findByUsername(uid);
        Project project=new Project(user,projectName);
        return projectServiceImpl.create(project,user);
    }

    //ProjectPage: Get all projects' code and name
    @GetMapping(path="/project/projectAll")
    public List<Project> getProjects() {
        return projectServiceImpl.readAll();
    }

    //ProjectPage: Delete a project
    @DeleteMapping(path="/project/projectDelete")
    public boolean deleteProjectById(@RequestParam Integer pid) {
        Project project=projectServiceImpl.get(pid);
        return projectServiceImpl.delete(project);
    }

    /**
     * ProjectResource
     */
    //ProjectResource default page
    @GetMapping(path="")
    public List<ProjectToResource> getProjectResourceByPid() {
        Project project=projectServiceImpl.get(1);
        return projectToResourceServiceImp.get(project);
    }

    //ProjectResource: get Project-Resource by pid
    @GetMapping(path="/project/{Pid}")
    public List<ProjectToResource> getProjectResourceByPid(@PathVariable Integer Pid) {
        Project project=projectServiceImpl.get(Pid);
        return projectToResourceServiceImp.get(project);
    }

    //ProjectResource: Add Project-Resource row
    @PostMapping(path = "/project/{pid}")
    public  boolean addProjectResopurce(@PathVariable Integer pid, @RequestParam Integer rid){
        Project project=projectServiceImpl.get(pid);
        Resource resource=resourceServiceImpl.get(rid);
        ProjectToResource projectToResource=new ProjectToResource(project,resource);
        return projectToResourceServiceImp.create(projectToResource,project,resource);
    }

    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/project/{pid}")
    public  boolean deleteProjectResource(@RequestParam Integer prid){
        ProjectToResource projectToResource=projectToResourceServiceImp.get(prid);
        return projectToResourceServiceImp.delete(projectToResource);
    }


}
