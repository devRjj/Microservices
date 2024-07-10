package com.velocity.inventory.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.velocity.inventory.model.Product;

@FeignClient(value = "PRODUCT-SERVICE",url = "http://localhost:8084/api/products")
public interface ProductService {

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id);

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails);

}
