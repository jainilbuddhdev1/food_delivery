package com.food_delivery.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CartEntity {

    @Id
    private Long id;

    @ManyToOne @JoinColumn(name = "user_id") @JsonIgnore
    private UserEntity userEntity;

    @Transient
    private Long userId;


    @ManyToOne @JoinColumn(name = "menu_item_id") @NotNull
    private MenuItemEntity menuItem;

    @Column
    private int quantity;
}
