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

    @Column @NotNull
    private Time closeTime;

    @Column
    private boolean deliveryChargeApplicable;

    @Column @Min(value = 0, message = "Discount cannot be less than 0 percent !!") @Max(value = 100,message = "Discount cannot be more than 100 percent !!")
    private int discount;

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

    @Column @Min(value = 0, message = "Average cannot be less than 0 !!")
    private int averageOrderTime;

    @Column @Min(value = 0, message = "Rating cannot be less than 0 !") @Max(value = 5, message = "Rating cannot be mpre than 5 !")
    private double rating;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuCategoryEntity> menuCategories;

}