package com.itlize.Korera;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectResource;
import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.repositories.ProjectResourceRepository;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.serviceImpl.ProjectResourceServiceImp;
import com.itlize.Korera.services.serviceImpl.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="{uid}/project")
public class projectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectServiceImp projectServiceImp;
    @Autowired
    ProjectResourceRepository projectResourceRepository;
    @Autowired
    ProjectResourceServiceImp projectResourceServiceImp;
    @Autowired
    UserRepository userRepository;
    /**
     * ProjectPage
     */
    //ProjectPage: Add a project
    @PostMapping(path = "/projectAdd")
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
        return projectServiceImp.deleteProjectById(pid);
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
    public  String addProjectResopurce(@PathVariable Integer pid, @RequestParam Integer rid){
        return projectResourceServiceImp.create(pid,rid);
    }
    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/{pid}")
    public  String deleteProjectResource(@RequestParam Integer prid){
        return projectResourceServiceImp.delete(prid);
    }

    //ProjectResource: update Project-Resource
    @PutMapping(path="/{pid}")
    public String updateProjectResource(@RequestParam Integer prid,@RequestParam Integer rid){
        return projectResourceServiceImp.update(prid, rid);
    }


}
