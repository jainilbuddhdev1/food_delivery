package com.food_delivery.controller;

import com.food_delivery.entity.RestaurantEntity;
import com.food_delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(
        origins = {
                "http://localhost:4200"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/all", produces = "application/json")
    public List<RestaurantEntity> getAllRestaurants()
    {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public RestaurantEntity createRestaurant(@RequestBody RestaurantEntity restaurant)
    {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping(value = "/{restaurantId}", produces = "application/json")
    public RestaurantEntity getRestaurant(@PathVariable("restaurantId") Long restaurantId)
    {
        return restaurantService.getRestaurant(restaurantId);
    }

    @GetMapping(value = "/category/{category}", produces = "application/json")
    public List<RestaurantEntity> getRestaurantByMenuItemCategory(@PathVariable("category") String category)
    {
        return restaurantService.getRestaurantByMenuItemCategory(category);
    }
}