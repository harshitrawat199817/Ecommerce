package com.ecommerce.CartMicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.CartMicroservice.exception.ResourceNotFoundException;
import com.ecommerce.CartMicroservice.model.Cart;
import com.ecommerce.CartMicroservice.model.CartItem;
import com.ecommerce.CartMicroservice.repository.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Cart createCart(Long userId) {
        Cart cart = new Cart(userId);
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart addItemToCart(Long cartId, Long productId, String productName, int quantity, Double price) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(ResourceNotFoundException::new);

        CartItem cartItem = new CartItem(productId, productName, quantity, price);
        cart.getCartItems().add(cartItem);

        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }

    public Cart updateCartItemQuantity(Long cartId, Long cartItemId, int newQuantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(ResourceNotFoundException::new);

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);

        cartItem.setQuantity(newQuantity);
        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }

    public Cart removeCartItem(Long cartId, Long cartItemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(ResourceNotFoundException::new);

        cart.getCartItems().removeIf(item -> item.getId().equals(cartItemId));
        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }
}

