package com.food_delivery.service;

import com.food_delivery.entity.MenuCategoryEntity;
import com.food_delivery.entity.RestaurantEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.repository.MenuCategoryRepository;
import com.food_delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoryService {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuCategoryEntity createMenuCategory(MenuCategoryEntity menuCategory) {
        RestaurantEntity restaurant = restaurantRepository.findById(menuCategory.getRestaurantId()).orElseThrow(() -> new ResourceNotFoundException("No Restaurant found with given Id !!"));
        menuCategory.setRestaurant(restaurant);
//        restaurant.getMenuCategories().add(menuCategory);
        menuCategory = menuCategoryRepository.save(menuCategory);
//        restaurantRepository.save(restaurant);
        return menuCategory;
//        return menuCategoryRepository.save(menuCategory);
    }
}