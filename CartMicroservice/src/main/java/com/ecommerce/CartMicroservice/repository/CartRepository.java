package com.ecommerce.CartMicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.CartMicroservice.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>  {

	Optional<Cart> findById(Long cartId);


}
