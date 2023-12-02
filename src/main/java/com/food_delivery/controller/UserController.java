package com.food_delivery.controller;

import com.food_delivery.entity.UserEntity;
import com.food_delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = {
                "http://localhost:4200"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
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

    @PostMapping(value = "/login"
            , consumes = "application/json"
            , produces = "application/json")
    public boolean login(
//            @RequestParam("email") String email
//            @RequestParam(value = "email") String email
//            , @RequestParam("password") String password
//            , @RequestParam("userType") Boolean userType
    @RequestBody UserEntity user) throws Exception {
        return userService.login(user.getEmailId(), user.getPassword(), user.isUserType());
    }
}