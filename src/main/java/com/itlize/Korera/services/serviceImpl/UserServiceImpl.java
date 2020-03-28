package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean create(User user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public User get(String userName) {

        Optional<User> a= userRepository.findById(userName);
        if(a.isPresent()){
            return a.get();
        }
        return null;
    }

    @Override
    public boolean update(String userName, User user) {
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
