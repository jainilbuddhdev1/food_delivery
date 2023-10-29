package com.food_delivery.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CartEntity {

    @Id
    @GeneratedValue
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
