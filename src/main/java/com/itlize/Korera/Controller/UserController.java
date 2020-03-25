package com.itlize.Korera.Controller;


import com.itlize.Korera.Dao.UserRepository;
import com.itlize.Korera.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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