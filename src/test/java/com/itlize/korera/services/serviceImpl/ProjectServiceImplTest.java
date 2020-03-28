package com.itlize.korera.services.serviceImpl;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.User2;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.User2Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private User2Service userService;

    @Test
    public void create() {
        Project toAdd = new Project();
        User2 user = User2Service.get("shabby1");
        boolean isSuccessful = projectService.create(toAdd,user);
        Assert.assertTrue(isSuccessful);
    }

    @Test
    public void delete() {
        Project toDelete = projectService.get(30);
        boolean isSuccessful = projectService.delete(toDelete);
        Assert.assertTrue(isSuccessful);
    }

    @Test
    public void get() {
        Project res = projectService.get(30);
        Assert.assertTrue(res!=null);
    }
}