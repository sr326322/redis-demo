package com.example.redisdemo.service;

import com.example.redisdemo.UserRepo;
import com.example.redisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public User add(User user) {
        return userRepo.add(user);
    }

    public List<User> getAll() {
       return userRepo.getAll();
    }

    public void reloadCache() {
        userRepo.reloadCache();
    }
}
