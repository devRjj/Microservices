package com.velocity.inventory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.velocity.inventory.model.MasterProduct;
import com.velocity.inventory.repo.MasterProductRepository;

@Controller
public class ProductViewController {

    private final MasterProductRepository repo;

    public ProductViewController(MasterProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/inventory/thymeleaf")
    public String getProducts(Model model) {
        List<MasterProduct> products = repo.findAll();
        model.addAttribute("inventory", products);
        return "products"; 
    }
}
