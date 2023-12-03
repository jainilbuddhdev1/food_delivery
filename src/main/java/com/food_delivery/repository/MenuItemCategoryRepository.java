package com.food_delivery.repository;

import com.food_delivery.entity.MenuItemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemCategoryRepository extends JpaRepository<MenuItemCategoryEntity, Long> {
//    public List<MenuItemCategoryEntity> findFirstSeven();
List<MenuItemCategoryEntity> findTop7ById(long id);
}
