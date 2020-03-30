package com.itlize.Korera.controller;
import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectToResource;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repository.ColumnsRepository;
import com.itlize.Korera.repository.ProjectRepository;
import com.itlize.Korera.repository.ProjectToResourceRepository;
import com.itlize.Korera.service.ColumnsService;
import com.itlize.Korera.service.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/resource")
public class resourceController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectServicelmpl projectServicelmpl;
    @Autowired
    ProjectToResourceRepository projectToResourceRepository;
    @Autowired
    ProjectToResourceServicelmpl projectToResourceServicelmpl;
    @Autowired
    ResourceServicelmpl resourceServicelmpl;
    @Autowired
    ResourceDetailsServicelmpl resourceDetailsServicelmpl;
    @Autowired
    ColumnsRepository columnsRepository;
    @Autowired
    ColumnsServiceImpl columnsServiceImpl;


    //Resource Page add a resource
    @PostMapping(path="/add")
    public boolean addResource(@RequestParam String resourceName){
        Resource resource=new Resource();
        resource.setResourceName(resourceName);
        return resourceServicelmpl.create(resource);
    }

    //Resource Page delete a resource
    @DeleteMapping(path="/delete")
    public boolean deleteResource(@RequestParam Integer rid){
        Resource resource=resourceServicelmpl.get(rid);
        return resourceServicelmpl.delete(resource);
    }

    //Resource page show all resources
    @GetMapping(path="/all")
    public List<Resource> getResources(){
        return resourceServicelmpl.getAll();
    }

    //Resource page show specific resources
    @GetMapping(path="/{rid}")
    public String getResource(@PathVariable Integer rid){
        return resourceServicelmpl.toJson(rid);
    }

    //Resource details page add a resource detail
    @PostMapping(path="/{rid}/addDetails")
    public boolean addDetail(@PathVariable Integer rid,@RequestParam String colName, @RequestParam String colVal, @RequestParam Integer pid){
    Resource resource=resourceServicelmpl.get(rid);
    Project project=projectServicelmpl.get(pid);
    Columns column=new Columns(project,colName);
    ResourceDetails resourceDetails=new ResourceDetails();
    return resourceDetailsServicelmpl.create(resourceDetails,resource,column);
    }

    //Resource details page delete a resource detail
    @DeleteMapping(path="/deleteDetails")
    public boolean deleteDetail(@RequestParam Integer rdid){
        ResourceDetails resourceDetails=resourceDetailsServicelmpl.get(rdid);
        return resourceDetailsServicelmpl.delete(resourceDetails);
    }

    //Resource details page update details
    @PutMapping(path="/updateDetails")
    public boolean updateDetail(@RequestParam String colName, @RequestParam String colVal,@RequestParam Integer rid, @RequestParam Integer pid){
        Resource resource=resourceServicelmpl.get(rid);
        Project project=projectServicelmpl.get(pid);
        Columns column=columnsServiceImpl.get(project,colName);
        return resourceDetailsServicelmpl.update(resource,column,colVal);
    }



}