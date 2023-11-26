package com.food_delivery.service;

import com.food_delivery.entity.UserEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.exception.WrongCredentialsException;
import com.food_delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        if ( !userRepository.existsByEmailId(user.getEmailId()) && !userRepository.existsByMobileNo(user.getMobileNo()) )
        {
            user.setHashedPassword(user.getPassword().hashCode());
            return userRepository.save(user);
        }
        throw new RuntimeException("User with given email or mobile number already exists");
    }

    public boolean login(String email, String password, boolean userType) throws Exception {
        UserEntity user = userRepository.findByEmailId(email);
        if (user != null) {
            if (user.isUserType()==userType) {
                if (user.getLastIncorrectAttemptTime() == null || LocalDateTime.now().minusMinutes(1).isAfter(user.getLastIncorrectAttemptTime())) {
                    int numberOfIncorrectAttempts = user.getNumberOfIncorrectAttempts();
                    if (password.hashCode() == user.getHashedPassword()) {
                        user.setLastIncorrectAttemptTime(null);
                        user.setNumberOfIncorrectAttempts(0);
                        userRepository.save(user);
                        return true;
                    }
                    if (numberOfIncorrectAttempts + 1 == 5)
                        user.setLastIncorrectAttemptTime(LocalDateTime.now());
                    user.setNumberOfIncorrectAttempts(numberOfIncorrectAttempts + 1);
                    userRepository.save(user);
                    throw new WrongCredentialsException();
                }
                throw new Exception("You have exceeded Maximum attempts please wait " + user.getLastIncorrectAttemptTime().plusMinutes(1));
            }
            throw new Exception("Please Choose correct user type for this id !!");
        }
        throw new ResourceNotFoundException("User with given emailId does not exist  !!");

    }
}
