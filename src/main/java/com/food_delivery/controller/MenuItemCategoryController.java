package com.food_delivery.controller;

import com.food_delivery.entity.MenuItemCategoryEntity;
import com.food_delivery.service.MenuItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/menuItemCategory")
@RestController
public class MenuItemCategoryController {

    @Autowired
    MenuItemCategoryService menuItemCategoryService;

    @GetMapping(value = "get7", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuItemCategoryEntity> getMenuItemCategorySeven()
    {
        return menuItemCategoryService.getMenuItemCategorySeven();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private MenuItemCategoryEntity createMenuItemCategoryEntity(@RequestBody MenuItemCategoryEntity menuItemCategory)
    {
        return menuItemCategoryService.createMenuItemCategoryEntity(menuItemCategory);
    }
}
