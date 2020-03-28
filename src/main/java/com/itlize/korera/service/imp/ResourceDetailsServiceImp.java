package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.ResourceDetails;
import com.itlize.korera.repository.ColumnsRepository;
import com.itlize.korera.repository.ResourceDetailsRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.service.ColumnsService;
import com.itlize.korera.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceDetailsServiceImp implements ResourceDetailsService {

    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ColumnsRepository columnsRepository;

    /*
     * @param resourceDetails: object to be created
     * @param resource: the resource object to which the detail belongs
     * create the given  resourceDetail and link it with resource
     */
    @Override
    public boolean create(ResourceDetails resourceDetails, Resource resource, Columns column) {
        if(resourceDetails==null || resource==null || column==null)
            return false;
        ResourceDetails target = get(resource,column);
        if (target!=null){
            System.out.println("resource detail has been created for "+target.toString());
            return false;
        }
        try {
            resourceDetailsRepository.save(resourceDetails);
            resource.addEntries(resourceDetails);
            column.addEntries(resourceDetails);
            columnsRepository.save(column);
            resourceDetailsRepository.save(resourceDetails);
            resourceRepository.save(resource);
        }catch(Exception e){
            System.out.println("Sth wrong happens: " + e.getMessage());
            return false;
        }
        System.out.println("Resource detail saved!");
        return true;
    }

    /*
     * @param resourceDetail: the obj to be deleted
     * delete the given resource Detail
     */
    @Override
    public boolean delete(ResourceDetails resourceDetails) {
        try {
            resourceDetailsRepository.delete(resourceDetails);
        }catch (Exception e){
            System.out.println("Sth wrong happens when deleting resourceDetail "  +  resourceDetails.toString());
            return false;
        }
        return true;
    }

    /*
     * @param id: if id>0 then update given id
     */
    @Override
    public boolean update(ResourceDetails resourceDetails) {
        try {
            resourceDetailsRepository.save(resourceDetails);
        }catch (Exception e){
            System.out.println("Sth wrong happens when updating:" + resourceDetails.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Resource resource, Columns column, String columnValue) {
        List<ResourceDetails> target  = resourceDetailsRepository.findByResourceAndColumn(resource,column);
        if(target.size()==0){
            System.out.println("nothing to be updated");
            return false;
        }
        target.get(0).setColumnValue(columnValue);
        resourceDetailsRepository.save(target.get(0));
        return true;
    }

    @Override
    public ResourceDetails get(Integer id) {
        Optional<ResourceDetails> ret = resourceDetailsRepository.findById(id);
        if(ret.isPresent()){
            return ret.get();
        }
        return null;
    }

    @Override
    public ResourceDetails get(Resource resource, Columns column) {
        List<ResourceDetails> ret = resourceDetailsRepository.findByResourceAndColumn(resource,column);
        if(ret.size()==0){
            //System.out.println(String.format("record for resource:%s and columnName:%s not found",resource.toString(),column.toString()));
            return null;
        }
        return ret.get(0);
    }

    @Override
    public List<ResourceDetails> get(Resource resource) {
        return resourceDetailsRepository.findByResource(resource);
    }
}