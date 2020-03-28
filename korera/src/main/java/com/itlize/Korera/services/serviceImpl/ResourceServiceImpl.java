package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public boolean create(Resource resource) {
        if(resource==null){
            System.out.println("null input detected");
            return false;
        }
        System.out.println("Adding "+ resource.toString());
        if(resource.getId()!=null) {
            Optional<Resource> target = resourceRepository.findById(resource.getId());
            if (target.isPresent()) {
                System.out.println("resource exist:" + resource.toString());
                return false;
            }
        }
        try{
            resourceRepository.save(resource);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("resource added.");
        return true;
    }

    @Override
    public boolean delete(Resource resource) {
        try{
            resourceRepository.delete(resource);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public Resource get(Integer id) {
        Optional<Resource> target = resourceRepository.findById(id);
        if(target.isPresent()){
            return target.get();
        }else{
            return null;
        }
    }
}
