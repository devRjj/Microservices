package com.velocity.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.inventory.model.MasterProduct;
import com.velocity.inventory.model.Product;
import com.velocity.inventory.service.InventoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventory Controller", description = "APIs for inventory service")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private final InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@Operation(summary = "Get product details by ID")
	@GetMapping("/product/{id}")
	public ResponseEntity<MasterProduct> getProductDetailsById(@PathVariable("id") Long productId) {
		MasterProduct product = inventoryService.getProductDetailsById(productId);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Add product to database")
	@PostMapping("/product")
    public ResponseEntity<MasterProduct> addProductData(@RequestBody Product product) {
        MasterProduct newProduct = inventoryService.addProductData(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

	@Operation(summary = "Helps us to maintain the product quantity in inventory")
	@PostMapping("/product/{id}/reduce")
	public ResponseEntity<MasterProduct> reduceProductQuantity(@PathVariable("id") Long productId,
			@RequestParam("qty") Integer qty) {
		try {
			MasterProduct updatedProduct = inventoryService.reduceQty(productId, qty);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
