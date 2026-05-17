package com.pawpalace.rest;

import com.pawpalace.model.User;
import com.pawpalace.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Integer> payload, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Please log in to add items to your cart."));
        }
        
        Long productId = payload.get("productId").longValue();
        int quantity = payload.getOrDefault("quantity", 1);
        
        cartService.addToCart(user.getId(), productId, quantity);
        return ResponseEntity.ok(Map.of("message", "Item successfully added to cart!"));
    }
}
