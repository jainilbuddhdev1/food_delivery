package com.food_delivery.controller;

import com.food_delivery.entity.UserEntity;
import com.food_delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signUp" , consumes = "application/json" , produces = "application/json")
    public UserEntity signUp(@RequestBody UserEntity user)
    {
        return userService.createUser(user);
    }

    @PostMapping(value = "/login" , produces = "application/json")
    public boolean login(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("userType") boolean userType) throws Exception {
        return userService.login(email,password,userType);
    }
}