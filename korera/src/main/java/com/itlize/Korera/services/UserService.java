package com.itlize.Korera.services;

import com.itlize.Korera.dbModels.User;

public interface UserService {
    public boolean createUser(User user);
    public boolean deleteUser(User user);
    public User getUser(String userName);
    public boolean updateUser(String userName, User user);
}
