package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.User;

public interface UserService {
    public boolean create(User user);
    public boolean delete(User user);
    public User get(String userName);
    public boolean update(String userName, User user);
}
