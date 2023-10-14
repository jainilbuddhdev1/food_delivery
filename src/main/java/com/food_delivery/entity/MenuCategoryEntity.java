package com.food_delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MenuCategoryEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column @NotNull @NotBlank
    private String name;

    @ManyToOne @NotNull
    @JsonIgnore
    private RestaurantEntity restaurant;

    @OneToMany(mappedBy = "menuCategory")
    private List<MenuItemEntity> menuItems;

    @Transient
    private Long restaurantId;
}
