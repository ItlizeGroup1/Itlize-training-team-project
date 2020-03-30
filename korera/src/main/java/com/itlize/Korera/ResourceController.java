package com.itlize.Korera;

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
@RequestMapping(path="/{uid}/resource")
public class ResourceController {
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
     * Resource
     */
    //Resource: get all resource
//    @GetMapping(path = "")
//    public List<Resource> getAll(){
//        return resourceServiceImp.getAll();
//    }
    @DeleteMapping(path="/resourceDelete")
    public String delete(@RequestParam Integer rid){
        return resourceServiceImp.delete(rid);
    }
    @PostMapping(path = "/resourceAddRow")
    public String create(@RequestParam Integer rCode,@RequestParam String resourceName){
        return resourceServiceImp.create(rCode,resourceName);
    }
    @PutMapping(path = "/resourceUpdate")
    public  String update(@RequestParam Integer rCode,@RequestParam String resourceName){
        return resourceServiceImp.create(rCode,resourceName);
    }
    /**
     * ResourceDetail
     */
    @PostMapping(path="/resourceAddCol")
    public String create(@RequestParam Integer rid, @RequestParam String columnName, @RequestParam String columnValue) {
        return resourceDetailsServiceImp.create(rid, columnName, columnValue);
    }
    @DeleteMapping(path="/resourceDeleteCol")
    public String delete(@RequestParam String columnName){
        return resourceDetailsServiceImp.deleteCol(columnName);
    }
    @PutMapping(path="/resourceColUpdate")
    public String deleteColVal(@RequestParam Integer rdid,@RequestParam String columnValue){
        return resourceDetailsServiceImp.update(rdid,columnValue);
    }
    @GetMapping(path = "/pool")
    public List<Object> getAllDetail(){
        return resourceDetailsServiceImp.getAll();
    }
}
