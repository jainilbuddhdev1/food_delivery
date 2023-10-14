package com.food_delivery.service;

import com.food_delivery.entity.RestaurantEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }


    public RestaurantEntity createRestaurant(RestaurantEntity restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public RestaurantEntity getRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException("No Restaurant found with given Id !!"));
    }

    public List<RestaurantEntity> getRestaurantByMenuItemCategory(String category) {
        return restaurantRepository.findAllByMenuCategoriesMenuItemsMenuItemCategory(category);
    }
}
