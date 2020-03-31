package com.itlize.Korera.controllers;


import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.services.ColumnsService;
import com.itlize.Korera.services.ResourceDetailsService;
import com.itlize.Korera.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ColumnsService columnsService;
    @Autowired
    private ResourceDetailsService resourceDetailsService;

    @GetMapping("/read")
    public ResponseEntity<?> read(){
        String body = resourceService.getAllJson();
        String columnDetails = columnsService.getColumnsJson(null);
        return new ResponseEntity<>(String.format("{\"columnInfo\":%s,\"tableDetail\":%s}", columnDetails,body), HttpStatus.OK);
    }

    @PostMapping("/addColumn")
    public ResponseEntity<?> addColumn(@RequestParam(name="columnName") String columnName){
        Columns columnToAdd = new Columns(columnName);
        boolean isSuccessful = columnsService.create(columnToAdd);
        if(isSuccessful){
            return new ResponseEntity<>(columnToAdd,HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"column name taken!\"}",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/deleteColumn")
    public ResponseEntity<?> deleteColumn(@RequestParam(name="columnName") String columnName){
        Columns columnToDelete = columnsService.get(null,columnName);
        boolean isSuccessful = columnsService.delete(columnToDelete);
        if(isSuccessful){
            return new ResponseEntity<>(columnToDelete,HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/updateColumn")
    public ResponseEntity<?> updateColumn(@RequestParam(name="oldColumnName") String oldColumnName,@RequestParam(name = "newColumnName")String newColumnName){
        Columns columnToUpdate = columnsService.get(null,oldColumnName);
        boolean isSuccessful = columnsService.update(columnToUpdate,newColumnName);
        if(isSuccessful){
            return new ResponseEntity<>(columnToUpdate,HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/addResource")
    public ResponseEntity<?> addResource(){
        Resource resourceToAdd = new Resource();
        resourceService.create(resourceToAdd);
        return new ResponseEntity<>(resourceToAdd, HttpStatus.OK);
    }

    @PostMapping("/addResourceByRow")
    public ResponseEntity<?> addResourceByRow(@RequestBody Map<String,String> properties){
        Resource resourceToAdd = new Resource();
        resourceService.create(resourceToAdd);
        boolean fullyWritten = true;
        for(String key : properties.keySet()) {
            //to finish
            Columns column = columnsService.get(null,key);
            if(column==null){
                fullyWritten=false;
                continue;
            }
            if(!setEntryHelper(resourceToAdd,column.getId(),properties.get(key)))
                fullyWritten=false;
        }
        if(fullyWritten)
            return new ResponseEntity<>(resourceService.toJson(resourceToAdd), HttpStatus.OK);
        return new ResponseEntity<>(resourceService.toJson(resourceToAdd), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/deleteResource")
    public ResponseEntity<?> deleteResource(@RequestParam(name = "resourceId")Integer resourceId){
        Resource resourceToDelete = resourceService.get(resourceId);
        if(resourceToDelete==null){
            return new ResponseEntity<>("{\"error\":\"resource does not exist!\"}",HttpStatus.BAD_REQUEST);
        }
        boolean isSuccessful = resourceService.delete(resourceToDelete);
        return new ResponseEntity<>(resourceToDelete, HttpStatus.OK);
    }

    @PostMapping("/setEntry")
    public ResponseEntity<?> setEntry(@RequestParam(name = "resourceId")Integer resourceId,
                                      @RequestParam(name = "columnId")Integer columnId,
                                      @RequestParam(name = "value") String value){
        Columns column = columnsService.get(columnId);
        if(column == null){
            return new ResponseEntity<>("{\"error\":\"column does not exist!\"}",HttpStatus.BAD_REQUEST);
        }
        Resource resource = resourceService.get(resourceId);
        if(resource==null){
            return new ResponseEntity<>("{\"error\":\"resource does not exist!\"}",HttpStatus.BAD_REQUEST);
        }
        ResourceDetails rd = resourceDetailsService.get(resource,column);
        if(rd==null){
            rd = new ResourceDetails();
            rd.setColumnValue(value);
            resourceDetailsService.create(rd,resource,column);
            return new ResponseEntity<>(rd, HttpStatus.OK);
        }
        rd.setColumnValue(value);
        boolean isSuccessful = resourceDetailsService.update(rd);
        if(isSuccessful){
            return new ResponseEntity<>(rd,HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"sth wrong happens:(\"}",HttpStatus.BAD_REQUEST);
    }

    private boolean setEntryHelper(Resource resource,Integer columnId,String value){
        if(resource == null)
            return false;
        Columns column = columnsService.get(columnId);
        if(column == null){
            return false;
        }
        ResourceDetails rd = resourceDetailsService.get(resource,column);
        if(rd==null){
            rd = new ResourceDetails();
            rd.setColumnValue(value);
            resourceDetailsService.create(rd,resource,column);
            return true;
        }
        rd.setColumnValue(value);
        boolean isSuccessful = resourceDetailsService.update(rd);
        if(isSuccessful){
            return true;
        }
        return false;
    }
}
