package com.itlize.korera.services.serviceImpl;


import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ResourceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceImplTest {

    @Autowired
    ResourceService resourceService;

    @Test
    public void all(){
        //create
        Integer id=100;
        Resource resource = new Resource();
        resource.setId(id);
        boolean success = resourceService.create(resource);
        Assert.assertTrue(success);
        //read
        Resource res = resourceService.get(id);
        Assert.assertTrue(res!=null);
        //delete
        success = resourceService.delete(res);
        Assert.assertTrue(success);
    }

    @Test
    public void create() {
        Resource resource = new Resource();
        boolean success = resourceService.create(resource);
        Assert.assertTrue(success);
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }
}