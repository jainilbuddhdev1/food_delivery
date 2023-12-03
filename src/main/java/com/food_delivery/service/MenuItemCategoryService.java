package com.food_delivery.service;

import com.food_delivery.entity.MenuItemCategoryEntity;
import com.food_delivery.repository.MenuItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemCategoryService {

    @Autowired
    private MenuItemCategoryRepository menuItemCategoryRepository;

    public List<MenuItemCategoryEntity> getMenuItemCategorySeven() {
        return menuItemCategoryRepository.findTop7ById(1);
    }

    public MenuItemCategoryEntity createMenuItemCategoryEntity(MenuItemCategoryEntity menuItemCategory) {
        return menuItemCategoryRepository.save(menuItemCategory);
    }
}
