package com.itlize.Korera.Service;

import com.itlize.Korera.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
