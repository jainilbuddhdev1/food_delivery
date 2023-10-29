package com.food_delivery.service;

import com.food_delivery.entity.CartEntity;
import com.food_delivery.exception.ResourceNotFoundException;
import com.food_delivery.repository.CartRepository;
import com.food_delivery.repository.MenuItemRepository;
import com.food_delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public CartEntity addToCart(CartEntity cart) {
        cart.setUserEntity(userRepository.findById(cart.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User with given user id not found")));
        return cartRepository.save(cart);
    }

    public List<CartEntity> getCartByUser(Long userId) {
        List<CartEntity> carts = cartRepository.findAllByUserEntityId(userId);
        carts.forEach(i -> i.setUserId(i.getUserEntity().getId()));
        return carts;
    }
}
