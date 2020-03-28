package com.itlize.korera.service;

import com.itlize.korera.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    List<User> findAllUsers();
}