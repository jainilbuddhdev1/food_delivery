package com.food_delivery.dto;

import com.food_delivery.entity.RestaurantEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EntityToDTOHelper {

    public static List<RestaurantListingDTO> RestaurantEntityToRestaurantDTO(List<RestaurantEntity> restaurants)
    {
        List<RestaurantListingDTO> restaurantListingDTOs = new ArrayList<>();
        for (RestaurantEntity restaurant : restaurants)
        {
            RestaurantListingDTO restaurantListingDTO = new RestaurantListingDTO();
            BeanUtils.copyProperties(restaurant, restaurantListingDTO);
            restaurantListingDTOs.add(restaurantListingDTO);
        }
        return restaurantListingDTOs;
    }

}
