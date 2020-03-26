package com.itlize.korera.controller;


import com.itlize.korera.entity.User1;
import com.itlize.korera.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hello")
public class UserController {
    @Autowired
    private UserRepository2 repository;



    @RequestMapping("/getUser")
    public User1 getUser() {
        User1 user = new User1();
        user.setUsername("wenxuan liu");
        user.setPassword("1234");
        return user;
    }

    @RequestMapping("/creatUser")
    public User1 create()  {
        User1 user = new User1();
        user.setUsername("Wenxuan Liu");
        user.setPassword("123456");
        return repository.save(user);
    }


}