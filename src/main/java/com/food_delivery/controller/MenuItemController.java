package com.food_delivery.controller;

import com.food_delivery.entity.MenuItemEntity;
import com.food_delivery.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
