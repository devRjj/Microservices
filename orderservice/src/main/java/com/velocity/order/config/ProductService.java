package com.velocity.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.velocity.order.model.Product;

@FeignClient(value = "PRODUCT-SERVICE",url = "http://localhost:8084/api/products")
public interface ProductService {

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id);

}
