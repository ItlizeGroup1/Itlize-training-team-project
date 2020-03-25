package com.itlize.korera.controller;


import com.itlize.korera.repository.UserRepository;
import com.itlize.korera.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hello")
public class UserController {
    @Autowired
    private UserRepository repository;



    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUsername("wenxuan liu");
        user.setPassword("1234");
        return user;
    }

    @RequestMapping("/creatUser")
    public User create()  {
        User user = new User();
        user.setUsername("Wenxuan Liu");
        user.setPassword("123456");
        return repository.save(user);
    }


}