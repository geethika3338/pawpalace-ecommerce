package com.pawpalace.controller;

import com.pawpalace.model.User;
import com.pawpalace.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        try {
            orderService.placeOrder(user.getId());
            return "redirect:/orders";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/cart?error=true";
        }
    }

    @GetMapping
    public String viewOrders(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        model.addAttribute("orders", orderService.getUserOrders(user.getId()));
        return "orders";
    }
}
