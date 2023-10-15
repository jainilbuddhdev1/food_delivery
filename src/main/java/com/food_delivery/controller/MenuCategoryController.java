package com.food_delivery.controller;

import com.food_delivery.entity.MenuCategoryEntity;
import com.food_delivery.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/menuCategory")
public class MenuCategoryController {

    @Autowired
    private MenuCategoryService menuCategoryService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MenuCategoryEntity createMenuCategory(@RequestBody MenuCategoryEntity menuCategory
//            , @RequestBody(required = false) int restaurantId
    )
    {
        return menuCategoryService.createMenuCategory(menuCategory);
    }
}
