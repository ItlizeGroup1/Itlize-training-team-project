package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public String create(Integer rCode, String resourceName) {
        try{
            Resource r = new Resource(rCode, resourceName);
            resourceRepository.save(r);
            return resourceName+" : "+rCode+" has been created successfully!";
        }catch (Exception e){
            e.getStackTrace();
            return "failed!";
        }

    }

    @Override
    public String delete(Integer rid) {
        try{
            resourceRepository.deleteById(rid);
        }catch(Exception e){
            e.printStackTrace();
            return "failed!";
        }
        return "Resource{"+rid+"} has been deleted successfully!";
    }


    @Override
    public List<Resource> getAll(){
        return resourceRepository.findAll();
    }
    @Override
    public String updateByRid(Integer rid, Integer rCode, String resourceName){
     Optional<Resource> op = resourceRepository.findById(rid);
     if(op.isPresent()){
         Resource r = op.get();
         r.setrCode(rCode);
         r.setResourceName(resourceName);
         resourceRepository.save(r);
         return "Resource{"+rid+"-"+resourceName+"} has been deleted successfully!";
     }else return "failed";
    }
}
