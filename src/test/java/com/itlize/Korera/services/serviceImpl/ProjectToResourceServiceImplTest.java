package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectToResource;
import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.services.ProjectService;
import com.itlize.Korera.services.ProjectToResourceService;
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
public class ProjectToResourceServiceImplTest {

    @Autowired
    private ProjectToResourceService projectToResourceService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;

    @Test
    public void create() {
        ProjectToResource ptr = new ProjectToResource();
        Resource resource = resourceService.get(9);
        Project project = projectService.get(29);
        boolean isSuccessful = projectToResourceService.create(ptr,project,resource);
        Assert.assertTrue(isSuccessful);

    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testGet1() {
    }
}