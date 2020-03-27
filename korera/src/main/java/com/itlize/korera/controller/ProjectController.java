package com.itlize.korera.controller;

import com.itlize.korera.entity.ProjectPage;
import com.itlize.korera.repository.ProjectPageRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ProjectUserRepository;
import com.itlize.korera.service.ProjectPageServiceImp;
import com.itlize.korera.service.ProjectResourceServiceImp;
import com.itlize.korera.service.ProjectUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //ProjectPage: Create a new project
    @PostMapping(path = "/create")
    public String create(@RequestParam Integer Pcode, @RequestParam String Pname){
        return projectPageServiceImp.createProject(Pcode,Pname);
    }

    //ProjectPage: Get all projects' code and name
    @PostMapping(path="/all")
    public List<ProjectPage> getProjectById() { return projectPageRepository.findAll(); }
    //Get project_resource by id


    //ProjectPage: Delete a project
    @DeleteMapping(path="/{id}")
    public String deleteProjectById(@PathVariable Integer id) {
        projectPageRepository.deleteById(id);
        return "deleted";
    }
    //ProjectResource: Add Project-Resource row
    @PostMapping(path = "/resourceAdd")
    public  String addProjectResource(@RequestParam Integer Pid, @RequestParam Integer Rid){
        return projectResourceServiceImp.addProjectResource(Pid,Rid);
    }
    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/resourceDelete")
    public  String deleteProjectResource(@RequestParam Integer PRid){
        return projectResourceServiceImp.deleteProjectResource(PRid);
    }

//    @PostMapping("")
//    public ResponseEntity<Object> createProject(@RequestBody ProjectPage pp) {
//        ProjectPage savedProject = projectPageRepository.save(pp);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(savedProject.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//
//    }
    @PostMapping(path="/{Pid}")
    public List<Integer> getProjectResourceByPid(@PathVariable Integer Pid) {
        return projectResourceServiceImp.getProjectResourceByPid(Pid);
    }

//    @PostMapping(path="")
//    public  List<Integer> getProjectByUserId(@PathVariable Integer Uid){
//        return projectUserServiceImp.getProjectByUserId(Uid);
//    }


}