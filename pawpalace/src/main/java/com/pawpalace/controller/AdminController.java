package com.pawpalace.controller;

import com.pawpalace.model.Product;
import com.pawpalace.model.User;
import com.pawpalace.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    private boolean isAdmin(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        return user != null && "ROLE_ADMIN".equals(user.getRole());
    }

    @GetMapping
    public String adminDashboard(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/";
        model.addAttribute("products", productService.getAllProducts());
        return "admin";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/";
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/";
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam Long id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/";
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
}
