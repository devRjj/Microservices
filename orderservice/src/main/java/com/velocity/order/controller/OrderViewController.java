package com.velocity.order.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.velocity.order.model.Order;
import com.velocity.order.repository.OrderRepository;

@Controller
public class OrderViewController {

    private final OrderRepository productService;

    public OrderViewController(OrderRepository productService) {
        this.productService = productService;
    }

    @GetMapping("/orders/thymeleaf")
    public String getProducts(Model model) {
        List<Order> orders = productService.findAll();
        model.addAttribute("orders", orders);
        return "orders"; 
    }
}
