package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.services.ResourceService;
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