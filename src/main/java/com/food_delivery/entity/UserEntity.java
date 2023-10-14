package com.food_delivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column @NotNull @NotBlank
    private String firstName;

    @Column @NotNull @NotBlank
    private String lastName;

    @Column @NotNull @NotBlank
    private String emailId;

    @Column @NotNull @NotBlank
    private String mobileNo;
}