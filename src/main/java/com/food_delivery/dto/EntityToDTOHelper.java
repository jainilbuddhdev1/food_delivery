package com.food_delivery.dto;

import com.food_delivery.entity.RestaurantEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EntityToDTOHelper {
    public static List<RestaurantListingDTO> RestaurantEntityToRestaurantDTO(List<RestaurantEntity> restaurants)
    {
        List<RestaurantListingDTO> restaurantListingDTOs = new ArrayList<>();
        BeanUtils.copyProperties(restaurants,restaurantListingDTOs);
        return restaurantListingDTOs;
    }
}
