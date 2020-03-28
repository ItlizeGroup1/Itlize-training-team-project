package com.itlize.korera.services.serviceImpl;


import com.itlize.korera.entity.User2;
import com.itlize.korera.service.User2Service;
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
    User2Service userService;

    @Test
    void createUser() {
        User2 toAdd = new User2("shabby2","admin","123");
        boolean a = userService.create(toAdd);
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