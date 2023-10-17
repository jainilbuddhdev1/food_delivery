package com.food_delivery.dto;

import lombok.Data;

@Data
public class RestaurantListingDTO {
    private Long id;

    private String name;

    private String imagePath;


    private String menuItemCategoryTwo;

}
