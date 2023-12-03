package com.food_delivery.service;

import com.food_delivery.dto.EntityToDTOHelper;
import com.food_delivery.dto.RestaurantListingDTO;
import com.food_delivery.entity.MenuItemCategoryEntity;
import com.food_delivery.entity.RestaurantEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<?> getAllRestaurants() {
//        return restaurantRepository.findAll();
        return EntityToDTOHelper.RestaurantEntityToRestaurantDTO(restaurantRepository.findAll());
    }


    public RestaurantEntity createRestaurant(RestaurantEntity restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public RestaurantEntity getRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException("No Restaurant found with given Id !!"));
    }

    public List<RestaurantListingDTO> getRestaurantByMenuItemCategory(long id) {
        MenuItemCategoryEntity menuItemCategory = new MenuItemCategoryEntity();
        menuItemCategory.setId(id);
        return EntityToDTOHelper.RestaurantEntityToRestaurantDTO(restaurantRepository.findAllByMenuCategoriesMenuItemsMenuItemCategory(menuItemCategory));
    }
}
