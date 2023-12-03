package com.food_delivery.service;

import com.food_delivery.entity.MenuCategoryEntity;
import com.food_delivery.entity.MenuItemCategoryEntity;
import com.food_delivery.entity.MenuItemEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.repository.MenuCategoryRepository;
import com.food_delivery.repository.MenuItemCategoryRepository;
import com.food_delivery.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Autowired
    private MenuItemCategoryRepository menuItemCategoryRepository;

    public MenuItemEntity createMenuItem(MenuItemEntity menuItem) {
        MenuCategoryEntity menuCategory = menuCategoryRepository.findById(menuItem.getMenuCategoryId()).orElseThrow(() -> new ResourceNotFoundException("No Menu Category found with given Id !!"));
        menuItem.setMenuCategory(menuCategory);
        MenuItemCategoryEntity menuItemCategory = menuItemCategoryRepository.findById(menuItem.getMenuItemCategoryId()).orElseThrow(() -> new ResourceNotFoundException("No Menu Item Category found with given Id !!"));
        menuItem.setMenuItemCategory(menuItemCategory);
        return menuItemRepository.save(menuItem);
    }
}
