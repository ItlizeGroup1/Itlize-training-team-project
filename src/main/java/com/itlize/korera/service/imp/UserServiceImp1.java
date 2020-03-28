package com.itlize.korera.service.imp;

import com.itlize.korera.entity.User2;
import com.itlize.korera.repository.UserRepository1;
import com.itlize.korera.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImp1 implements User2Service {

    @Autowired
    UserRepository1 userRepository;

    @Override
    public boolean create(User2 user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User2 user) {
        userRepository.delete(user);
        return true;
    }

    public User2 get(String userName) {
        Optional<User2> a= userRepository.findById(userName);
        if(a.isPresent()){
            return a.get();
        }
        return null;
    }

    @Override
    public boolean update(String userName, User2 user) {
        User2 toUpdate = userRepository.getOne(userName);
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
