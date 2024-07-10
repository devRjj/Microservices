package com.velocity.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.velocity.product.config.InventoryService;
import com.velocity.product.model.Product;
import com.velocity.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final ProductRepository productRepository;
	private final InventoryService inventoryService;

	public ProductServiceImpl(ProductRepository productRepository, InventoryService inventoryService) {
		this.productRepository = productRepository;
		this.inventoryService = inventoryService;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long Id) {
		return productRepository.findById(Id).orElse(null);
	}

	@Override
	public Product addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		inventoryService.addProductData(savedProduct);
		return savedProduct;
	}

	@Override
	public Product updateProductData(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
