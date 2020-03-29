package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ColumnsService;
import com.itlize.Korera.services.ResourceDetailsService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ResourceDetailsServiceImplTest {

    @Autowired
    private ResourceDetailsService resourceDetailsService;
    @Autowired
    private ColumnsService columnsService;
    @Autowired
    private ResourceRepository resourceRepository;



    @Test
    public void create() {
        Columns column = columnsService.get(40);
        Optional<Resource> resource = resourceRepository.findById(9);
        if(resource.isPresent()){
        ResourceDetails newRD = new ResourceDetails("colValue");
        boolean isSuccessful = resourceDetailsService.create(newRD,resource.get(),column);
        Assert.assertTrue(isSuccessful);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void delete() {
        Columns column = columnsService.get(5);
        Optional<Resource> resource = resourceRepository.findById(6);
        if(resource.isPresent()){
            ResourceDetails rd = resourceDetailsService.get(resource.get(),column);
            boolean isSuccessful = resourceDetailsService.delete(rd);
            Assert.assertTrue(isSuccessful);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void update() {
        Columns column = columnsService.get(21);
        Optional<Resource> resource = resourceRepository.findById(9);
        if(resource.isPresent()){
            boolean isSuccessful = resourceDetailsService.update(resource.get(),column,"newValue");
            Assert.assertTrue(isSuccessful);
        }else{
            System.out.println("failed to get resource");
        }

    }

    @Test
    public void get() {
        Columns column = columnsService.get(21);
        Optional<Resource> resource = resourceRepository.findById(9);
        if(resource.isPresent()){
            Resource rsrc = resource.get();
            System.out.println(rsrc.toString());
            ResourceDetails target = resourceDetailsService.get(rsrc,column);
            Assert.assertTrue(target!=null);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void getByResource() {
        Optional<Resource> resource = resourceRepository.findById(9);
        if(resource.isPresent()){
            Resource rsrc = resource.get();
            System.out.println(rsrc.toString());
            List<ResourceDetails> target = resourceDetailsService.get(rsrc);
            for(ResourceDetails rd : target){
                System.out.println(rd.toString());
            }
            Assert.assertTrue(target.size()>0);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void getById() {
        ResourceDetails target = resourceDetailsService.get(14);
        Assert.assertTrue(target!=null);

    }
}