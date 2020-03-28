package com.itlize.korera.controller;

import com.itlize.korera.entity.ProjectPage;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.ProjectUser;
import com.itlize.korera.repository.ProjectPageRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ProjectUserRepository;
import com.itlize.korera.service.imp.ProjectPageServiceImp;
import com.itlize.korera.service.imp.ProjectResourceServiceImp;
import com.itlize.korera.service.imp.ProjectUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;



@RestController
@RequestMapping(path="/ProjectPage")
public class ProjectController {

    @Autowired
    ProjectPageRepository projectPageRepository;

    @Autowired
    ProjectPageServiceImp projectPageServiceImp;

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Autowired
    ProjectResourceServiceImp projectResourceServiceImp;

    @Autowired
    ProjectUserRepository projectUserRepository;

    @Autowired
    ProjectUserServiceImp projectUserServiceImp;


    //ProjectPage: Add a project
    @PostMapping(path = "/projectAdd")
    public String createProject(@RequestParam Integer pcode, @RequestParam String pname){
        return projectPageServiceImp.createProject(pcode,pname);
    }

    //ProjectPage: Get all projects' code and name
    @GetMapping(path="/projectAll")
    public List<ProjectPage> getProjects() {
        return projectPageServiceImp.getProjects();
    }


    //ProjectPage: Delete a whole project
    @DeleteMapping(path="/{pid}/projectDelete")
    public String deleteProjectById(@PathVariable Integer pid) {
        projectPageServiceImp.deleteProjectById(pid);
        return"done!";
    }

    //ProjectPage: Update Project
    @PutMapping(path="/{pid}/projectUpdate")
    public String updateProject(@PathVariable Integer pid, Integer pcode,String pname){
        return projectPageServiceImp.updateProject( pid,  pcode, pname);
    }

    /**
     * ProjectResource
     */
    //ProjectResource default page
    @GetMapping(path="")
    public List<ProjectResource> getProjectResourceByPid() {
        return projectResourceServiceImp.getProjectResourceByPid(1);
    }

    //ProjectResource: Add Project-Resource row
    @PostMapping(path = "/{pid}")
    public  String addProjectResource(@PathVariable Integer pid, @RequestParam Integer rid){
        return projectResourceServiceImp.addProjectResource(pid,rid);
    }

    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/{pid}")
    public  String deleteProjectResource(@RequestParam Integer prid){
        return projectResourceServiceImp.deleteProjectResource(prid);
    }

    //ProjectResource: get Project-Resource by pid
    @GetMapping(path="/{Pid}")
    public List<ProjectResource> getProjectResourceByPid(@PathVariable Integer Pid) {
        return projectResourceServiceImp.getProjectResourceByPid(Pid);
    }

    //ProjectResource: update Project-Resource
    @PutMapping(path="/{pid}")
    public String updateProjectResource(@RequestParam Integer prid, @RequestParam Integer rid){
        return projectResourceServiceImp.updateProjectResource(prid, rid);
    }

    /**
     * ProjectUser
     */
//    @PostMapping(path = "/{Uid}")
//    public  String addProjectUser(@PathVariable Integer uid, @RequestParam Integer pid){
//        return projectUserServiceImp.addProjectUser(uid,pid);
//    }
//    @GetMapping(path="/{Uid}")
//    public  List<ProjectUser> getProjectByUserId(@PathVariable Integer Uid){
//        return projectUserServiceImp.getProjectByUserId(Uid);
//    }

}