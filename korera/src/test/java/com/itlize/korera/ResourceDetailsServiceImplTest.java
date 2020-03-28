package com.itlize.korera;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.ResourceDetails;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.service.ResourceDetailsService;
import org.junit.Assert;
import org.junit.Test;
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
    ResourceDetailsService resourceDetailsService;

    @Autowired
    ResourceRepository resourceRepository;

    @Test
    public void create() {
        Optional<Resource> resource = resourceRepository.findById(1);
        if(resource.isPresent()){
            ResourceDetails newRD = new ResourceDetails( "column1 ", "value");
            boolean isSuccessful = resourceDetailsService.create(newRD,resource.get());
            Assert.assertTrue(isSuccessful);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
        Optional<Resource> resource = resourceRepository.findById(1);
        if(resource.isPresent()){
            boolean isSuccessful = resourceDetailsService.update(resource.get(),"column1","newValue");
            Assert.assertTrue(isSuccessful);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void get() {
        Optional<Resource> resource = resourceRepository.findById(1);
        if(resource.isPresent()){
            Resource rsrc = resource.get();
            System.out.println(rsrc.toString());
            ResourceDetails target = resourceDetailsService.get(rsrc,"column1");
            Assert.assertTrue(target!=null);
        }else{
            System.out.println("failed to get resource");
        }
    }

    @Test
    public void getByResource() {
        Optional<Resource> resource = resourceRepository.findById(1);
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