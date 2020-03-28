package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repositories.ResourceDetailsRepository;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    /*
     * @param resourceDetails: object to be created
     * @param resource: the resource object to which the detail belongs
     * create the given  resourceDetail and link it with resource
     */
    @Override
    public boolean create(ResourceDetails resourceDetails, Resource resource) {
        List<ResourceDetails> target = resourceDetailsRepository.findByResourceAndColumnName(resourceDetails.getResource(),
                                                                                                resourceDetails.getColumnName());
        if (target.size()>0){
            System.out.println("resource detail has been created for "+target.get(0).toString());
            return false;
        }
        try {
            resourceDetailsRepository.save(resourceDetails);
            resource.addEntries(resourceDetails);
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
    public boolean update(Resource resource, String columnName, String columnValue) {
        List<ResourceDetails> target  = resourceDetailsRepository.findByResourceAndColumnName(resource,columnName);
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
    public ResourceDetails get(Resource resource, String columnName) {
        List<ResourceDetails> ret = resourceDetailsRepository.findByResourceAndColumnName(resource,columnName);
        if(ret.size()==0){
            System.out.println(String.format("record for resource:%s and columnName:%s not found",resource.toString(),columnName));
            return null;
        }
        return ret.get(0);
    }

    @Override
    public List<ResourceDetails> get(Resource resource) {
        return resourceDetailsRepository.findByResource(resource);
    }

    @Override
    public List<ResourceDetails> get(String columnName) {
        return resourceDetailsRepository.findByColumnName(columnName);
    }
}
