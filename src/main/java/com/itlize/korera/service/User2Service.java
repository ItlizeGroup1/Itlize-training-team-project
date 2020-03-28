package com.itlize.korera.service;


import com.itlize.korera.entity.User2;

public interface User2Service {
    public boolean create(User2 user);
    public boolean delete(User2 user);

    public static User2 get(String userName) {
        return null;
    }

    public boolean update(String userName, User2 user);
}