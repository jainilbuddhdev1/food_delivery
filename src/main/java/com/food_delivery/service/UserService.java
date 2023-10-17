package com.food_delivery.service;

import com.food_delivery.entity.UserEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.exception.WrongCredentialsException;
import com.food_delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        user.setHashedPassword(user.getPassword().hashCode());
        return userRepository.save(user);
    }

    public boolean login(String email, String password) throws Exception {
        UserEntity user = userRepository.findByEmailId(email);
        if (user != null) {
            if (user.getLastIncorrectAttemptTime()!=null && LocalDateTime.now().plusMinutes(1).isBefore(user.getLastIncorrectAttemptTime())) {
                int numberOfIncorrectAttempts = user.getNumberOfIncorrectAttempts();
                if (password.hashCode() == user.getHashedPassword()) {
                    user.setLastIncorrectAttemptTime(null);
                    userRepository.save(user);
                    return true;
                }
                if (numberOfIncorrectAttempts+1==5)
                    user.setLastIncorrectAttemptTime(LocalDateTime.now());
                user.setNumberOfIncorrectAttempts(numberOfIncorrectAttempts+1);
                throw new WrongCredentialsException();
            }
            throw new Exception("You have exceeded Maximum attempts please wait " + user.getLastIncorrectAttemptTime().plusMinutes(1) );
        }
        throw new ResourceNotFoundException("user with given emailId does not exist");

    }
}
