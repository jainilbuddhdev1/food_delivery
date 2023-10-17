package com.food_delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer hashedPassword;

    @Column @NotNull @NotBlank
    private String firstName;

    @Column @NotNull @NotBlank
    private String lastName;

    @Column @NotNull @NotBlank
    private String emailId;

    @Column @NotNull @NotBlank
    private String mobileNo;

    @Transient
    private String password;

    @Column
    private int numberOfIncorrectAttempts;

    @Column
    private LocalDateTime lastIncorrectAttemptTime;
}