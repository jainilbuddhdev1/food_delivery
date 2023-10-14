package com.food_delivery.repository;

import com.food_delivery.entity.RestaurantEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findAllByMenuCategoriesMenuItemsMenuItemCategory(String category);
}
