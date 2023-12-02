package com.food_delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MenuItemEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column @NotBlank
    private String name;

    @Column @Min(value = 0, message = "Price cannot be negative !!")
    private int price;

    @Column
    private boolean vegetarian;

    @Column
//    @NotNull @NotBlank
    private String imagePath;

    @ManyToOne @NotNull @JoinColumn(name = "category_id")
    @JsonIgnore
    private MenuCategoryEntity menuCategory;

    @Column @NotNull @NotBlank
    private String menuItemCategory;

    @OneToMany(mappedBy = "menuItem") @JsonIgnore
    private List<CartEntity> cartItems;

    @Transient
    private Long menuCategoryId;
}
