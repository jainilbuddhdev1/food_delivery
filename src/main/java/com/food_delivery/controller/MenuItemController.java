package com.food_delivery.controller;

import com.food_delivery.entity.MenuItemEntity;
import com.food_delivery.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/menuItem")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public MenuItemEntity createMenuItem(@RequestBody MenuItemEntity menuItem)
    {
        return menuItemService.createMenuItem(menuItem);
    }
}
