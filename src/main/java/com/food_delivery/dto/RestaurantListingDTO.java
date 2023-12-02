package com.food_delivery.dto;

import lombok.Data;

@Data
public class RestaurantListingDTO {
    private Long id;

    private String name;

    private String imagePath;

//    private String menuItemCategoryOne;
//
//    private String menuItemCategoryTwo;

    private int averageOrderTime;

    private double rating;

    private boolean vegetarian;

}
