package com.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Entity
@Data
public class RestaurantEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column @NotNull @NotBlank
    private String name;

    @Column @NotNull @NotBlank
    private String address;

    @Column @NotNull @NotBlank
    private String city;

    @Column @NotNull
    private Time openTime;

    @Column
    private String imagePath;

    @Column
    private boolean vegetarian;

//    @OneToOne
//    private MenuItemEntity menuItemOne;
//
//    @OneToOne
//    private MenuItemEntity menuItemTwo;
//
//    @OneToOne
//    private MenuItemEntity menuItemThree;

    @Column @Min(0)
    private int averageOrderTime;

    @Column @Min(value = 0, message = "rating cannot be less than 0 !") @Max(value = 5, message = "rating cannot be mpre than 5 !")
    private double rating;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuCategoryEntity> menuCategories;

}