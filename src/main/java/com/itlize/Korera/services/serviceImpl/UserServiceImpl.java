package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(User user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public User getUser(String userName) {
        return userRepository.getOne(userName);
    }

    @Override
    public boolean updateUser(String userName, User user) {
        User toUpdate = userRepository.getOne(userName);
        toUpdate.setUserName(user.getUserName());
        toUpdate.setTitle(user.getTitle());
        toUpdate.setPassword(user.getPassword());
        try{
            userRepository.save(toUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
