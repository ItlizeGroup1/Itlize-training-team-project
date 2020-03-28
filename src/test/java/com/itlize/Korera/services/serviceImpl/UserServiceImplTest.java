package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;


    @Test
    void createUser() {
        User toAdd = new User("shabby1","admin","123");
        boolean a = userService.createUser(toAdd);
        Assert.assertTrue(a);
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }
}