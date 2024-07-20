package com.velocity.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.product.model.Product;
import com.velocity.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product Controller", description = "APIs for managing products")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Operation(summary = "Get all products")
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		LOG.info("Fetching all products");
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		LOG.info("Fetching product with ID: {}", id);
		Product product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		LOG.info("Adding new product");
		Product newProduct = productService.addProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		LOG.info("Updating product with ID: {}", id);
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			productDetails.setId(id);
			Product updatedProduct = productService.updateProductData(productDetails);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		LOG.info("Deleting product with ID: {}", id);
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
