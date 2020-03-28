package com.itlize.korera.services.serviceImpl;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectToResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ProjectToResourceService;
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