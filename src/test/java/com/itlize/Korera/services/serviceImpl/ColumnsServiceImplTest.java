package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.services.ColumnsService;
import com.itlize.Korera.services.ProjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Column;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnsServiceImplTest {

    @Autowired
    ColumnsService columnsService;
    @Autowired
    ProjectService projectService;

    @Test
    public void all(){
        //create
        Columns toAdd = new Columns(null, "testColumn");
        boolean isSuccessful = columnsService.create(toAdd);
        Assert.assertTrue(isSuccessful);
        //read
        Columns res = columnsService.get(toAdd.getProject(),toAdd.getColumnName());
        System.out.println(res.toString());
        Assert.assertTrue(res!=null);
        //update
        Columns toUpdate = res;
        isSuccessful = columnsService.update(toUpdate,"newColumnName");
        Assert.assertTrue(isSuccessful);
        //delete
        isSuccessful = columnsService.delete(toUpdate);
        Assert.assertTrue(isSuccessful);

    }

    @Test
    public void create() {
        Columns toAdd = new Columns(null, "testColumn");
        Project project = projectService.get(38);
        boolean isSuccessful = columnsService.create(toAdd,project);
        Assert.assertTrue(isSuccessful);
    }

    @Test
    public void delete() {
        Columns toUpdate = columnsService.get(19);
        boolean isSuccessful = columnsService.delete(toUpdate);
        Assert.assertTrue(isSuccessful);
    }

    @Test
    public void update() {
        Columns toUpdate = columnsService.get(19);
        boolean isSuccessful = columnsService.update(toUpdate,"newColumnName");
        Assert.assertTrue(isSuccessful);
    }

    @Test
    public void get() {
        Columns res = columnsService.get(19);
        System.out.println(res.toString());
        Assert.assertTrue(res!=null);
    }

    @Test
    public void testGet() {
    }
}