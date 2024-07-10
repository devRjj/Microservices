package com.velocity.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
