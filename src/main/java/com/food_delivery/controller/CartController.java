package com.food_delivery.controller;

import com.food_delivery.entity.CartEntity;
import com.food_delivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public CartEntity addToCart(@RequestBody CartEntity cart)
    {
        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<CartEntity> getCartByUser(@PathVariable("userId") Long userId)
    {
        return cartService.getCartByUser(userId);
    }
}
