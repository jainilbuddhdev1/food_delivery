package com.food_delivery.entity;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "restaurant")
    private List<MenuCategoryEntity> menuCategories;

}