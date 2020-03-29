package com.itlize.Korera;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectResource;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.repositories.ProjectResourceRepository;
import com.itlize.Korera.services.serviceImpl.ProjectResourceServiceImp;
import com.itlize.Korera.services.serviceImpl.ProjectServiceImp;
import com.itlize.Korera.services.serviceImpl.ResourceDetailsServiceImpl;
import com.itlize.Korera.services.serviceImpl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/{uid}")
public class projectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectServiceImp projectServiceImp;
    @Autowired
    ProjectResourceRepository projectResourceRepository;
    @Autowired
    ProjectResourceServiceImp projectResourceServiceImp;
//    @Autowired
//    UserRepository userRepository;
    @Autowired
    ResourceServiceImpl resourceServiceImp;
    @Autowired
    ResourceDetailsServiceImpl resourceDetailsServiceImp;

    /**
     * ProjectPage
     */
    //ProjectPage: Add a project
    @PostMapping(path = "/project/projectAdd")
    public String createProject(@RequestParam Integer pid,@RequestParam String projectName,@PathVariable String uid){
        return projectServiceImp.create(pid, projectName,uid);
    }
    //ProjectPage: Get all projects' code and name
    @GetMapping(path="/project/projectAll")
    public List<Project> getProjects() {
        return projectServiceImp.readAll();
    }

    //ProjectPage: Delete a project
    @DeleteMapping(path="/project/projectDelete")
    public String deleteProjectById(@RequestParam Integer pid) {
        return projectServiceImp.deleteProjectById(pid);
    }

    //ProjectPage: Update Project
    @PutMapping(path="/project/projectUpdate")
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
    @GetMapping(path="/project/{Pid}")
    public List<ProjectResource> getProjectResourceByPid(@PathVariable Integer Pid) {
        return projectResourceServiceImp.readByProject(Pid);
    }
    //ProjectResource: Add Project-Resource row
    @PostMapping(path = "/project/{pid}")
    public  String addProjectResopurce(@PathVariable Integer pid, @RequestParam Integer rid){
        return projectResourceServiceImp.create(pid,rid);
    }
    //ProjectResource: delete Project-Resource row
    @DeleteMapping (path = "/project/{pid}")
    public  String deleteProjectResource(@RequestParam Integer prid){
        return projectResourceServiceImp.delete(prid);
    }

    //ProjectResource: update Project-Resource
    @PutMapping(path="/project/{pid}")
    public String updateProjectResource(@RequestParam Integer prid,@RequestParam Integer rid){
        return projectResourceServiceImp.update(prid, rid);
    }
    /**
     * Resource
     */
    //Resource: get all resource
    @GetMapping(path = "/resource/resourceAll")
    public List<Resource> getAll(){
        return resourceServiceImp.getAll();
    }
    @DeleteMapping(path="/resource/resourceDelete")
    public String delete(@RequestParam Integer rid){
        return resourceServiceImp.delete(rid);
    }
    @PostMapping(path = "/resource/resourceAddRow")
    public String create(@RequestParam Integer rCode,@RequestParam String resourceName){
        return resourceServiceImp.create(rCode,resourceName);
    }
    @PutMapping(path = "/resource/resourceUpdate")
    public  String update(@RequestParam Integer rCode,@RequestParam String resourceName){
        return resourceServiceImp.create(rCode,resourceName);
    }
    /**
     * ResourceDetail
     */
    @PostMapping(path="/resource/resourceAddCol")
    public String create(@RequestParam Integer rid, @RequestParam String columnName, @RequestParam String columnValue) {
        return resourceDetailsServiceImp.create(rid, columnName, columnValue);
    }
    @DeleteMapping(path="/resource/resourceDeleteCol")
    public String delete(@RequestParam String columnName){
        return resourceDetailsServiceImp.deleteCol(columnName);
    }
    @PutMapping(path="/resource/resourceColUpdate")
    public String deleteColVal(@RequestParam Integer rdid,@RequestParam String columnValue){
        return resourceDetailsServiceImp.update(rdid,columnValue);
    }
    @GetMapping(path = "/resource/Detail")
    public List<ResourceDetails> getAllDetail(){
        return resourceDetailsServiceImp.getAll();
    }
}
