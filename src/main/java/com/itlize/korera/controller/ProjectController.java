package com.itlize.korera.controller;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.User2;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.UserRepository1;
import com.itlize.korera.service.imp.ProjectResourceServiceImp;
import com.itlize.korera.service.imp.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="{uid}/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectServiceImp projectServiceImp;

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Autowired
    ProjectResourceServiceImp projectResourceServiceImp;

    @Autowired
    UserRepository1 userRepository;

    /**
     * ProjectPage
     */
    //ProjectPage: Add a project
    @PostMapping(path = "/prpojectAdd")
    public String createProject(@RequestParam Integer pid,@RequestParam String projectName,@PathVariable String uid){
        return projectServiceImp.create(pid, projectName,uid);
    }

    //ProjectPage: Get all projects' code and name
    @GetMapping(path="/projectAll")
    public List<Project> getProjects() {
        return projectServiceImp.readAll();
    }

    //ProjectPage: Delete a project
    @DeleteMapping(path="/projectDelete")
    public String deleteProjectById(@RequestParam Integer pid) {
        if(projectServiceImp.deleteProjectById(pid)){
            return "Project{"+pid+"} has been deleted successfully!";
        }else return "failed";
    }

    //ProjectPage: Update Project
    @PutMapping(path="/projectUpdate")
    public String update(@RequestParam Integer pid,@RequestParam String projectName,@PathVariable String uid){
        return projectServiceImp.update(pid, projectName, uid);
    }

    /**
     * ProjectResource
     */
    //ProjectResource default page
    @GetMapping(path="")
    public List<ProjectResource> getProjectResourceByPid() {
        return projectResourceServiceImp.readByProject(1);
    }

    //ProjectResource: get Project-Resource by pid
    @GetMapping(path="/{Pid}")
    public List<ProjectResource> getProjectResourceByPid(@PathVariable Integer Pid) {
        return projectResourceServiceImp.readByProject(Pid);
    }

    //ProjectResource: Add Project-Resource row
    @PostMapping(path = "/{pid}")
    public  String addProjectResource(@PathVariable Integer pid, @RequestParam Integer rid){
        return projectResourceServiceImp.create(pid,rid);
    }

    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/{pid}")
    public  String deleteProjectResource(@RequestParam Integer prid){
        return projectResourceServiceImp.delete(prid);
    }

    //ProjectResource: update Project-Resource
    @PutMapping(path="/{pid}")
    public String updateProjectResource(@RequestParam Integer prid,@PathVariable Integer pid,@RequestParam Integer rid){
        return projectResourceServiceImp.update(prid, pid, rid);
    }
}