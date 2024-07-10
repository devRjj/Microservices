package com.velocity.product.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.velocity.product.model.MasterProduct;
import com.velocity.product.model.Product;

@FeignClient(value = "INVENTORY-SERVICE",url = "http://localhost:8081/api/inventory")
public interface InventoryService {
	
	@PostMapping("/product")
    public ResponseEntity<MasterProduct> addProductData(@RequestBody Product product);
	
	@GetMapping("/product/{id}")
	public ResponseEntity<MasterProduct> getProductDetailsById(@PathVariable("id") Long productId);
	
	@PostMapping("/product/{id}/reduce")
	public ResponseEntity<MasterProduct> reduceProductQuantity(@PathVariable("id") Long productId,
			@RequestParam("qty") Integer qty);

}
