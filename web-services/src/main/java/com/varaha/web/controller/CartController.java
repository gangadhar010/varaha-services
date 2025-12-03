package com.varaha.web.controller;

import com.varaha.common.model.Cart;
import com.varaha.common.service.CartService;
import com.varaha.web.dto.AddCartItemRequest;
import com.varaha.web.dto.UpdateCartItemRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody(required = false) Map<String, String> requestBody) {
        String sessionId = (requestBody != null) ? requestBody.get("sessionId") : null;
        Cart cart = cartService.createCart(sessionId);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable String cartId) {
        Cart cart = cartService.getCartById(cartId);
        // In a real app, you'd handle a null cart and return 404
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<Cart> addItemToCart(@PathVariable String cartId, @Valid @RequestBody AddCartItemRequest request) {
        Cart updatedCart = cartService.addItemToCart(cartId, request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @PutMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> updateItemQuantity(@PathVariable String cartId, @PathVariable String itemId, @Valid @RequestBody UpdateCartItemRequest request) {
        Cart updatedCart = cartService.updateItemQuantity(cartId, itemId, request.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable String cartId, @PathVariable String itemId) {
        Cart updatedCart = cartService.removeItemFromCart(cartId, itemId);
        return ResponseEntity.ok(updatedCart);
    }

    @PostMapping("/merge")
    public ResponseEntity<Cart> mergeCarts(@RequestBody Map<String, String> requestBody) {
        String guestCartId = requestBody.get("guestCartId");
        // Add validation to ensure guestCartId is not null
        Cart mergedCart = cartService.mergeCarts(guestCartId);
        return ResponseEntity.ok(mergedCart);
    }
}
