package com.pawpalace.service;

import com.pawpalace.model.Order;
import com.pawpalace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CartService cartService;

    public Order placeOrder(Long userId) {
        BigDecimal total = cartService.calculateTotal(userId);
        if (total.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Cart is empty");
        }
        
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order = orderRepository.save(order);
        
        cartService.clearCart(userId);
        
        return order;
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
