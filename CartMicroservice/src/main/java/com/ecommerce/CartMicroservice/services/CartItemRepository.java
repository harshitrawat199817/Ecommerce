package com.ecommerce.CartMicroservice.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.CartMicroservice.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
