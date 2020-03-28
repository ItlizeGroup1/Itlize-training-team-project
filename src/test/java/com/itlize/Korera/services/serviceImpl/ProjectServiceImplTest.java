package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.services.ProjectService;
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

    @Test
    public void create() {
        Project toAdd = new Project();
        toAdd.setId(1);
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }
}