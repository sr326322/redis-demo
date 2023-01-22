package com.example.redisdemo.controller;

import com.example.redisdemo.model.User;
import com.example.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/fetchAll")
    public List<User> get() {
        return userService.getAll();
    }

    @GetMapping("/reloadCache")
    public void reload() {
        userService.reloadCache();
    }


}
