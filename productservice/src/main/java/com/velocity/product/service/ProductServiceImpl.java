package com.velocity.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.velocity.product.config.InventoryService;
import com.velocity.product.enums.ErrorCodes;
import com.velocity.product.exception.NoSuchProductExistsException;
import com.velocity.product.exception.ProductAlreadyExistsException;
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
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new NoSuchProductExistsException("NO CUSTOMER PRESENT WITH ID = "+ id, ErrorCodes.DATA_NOT_FOUND.getCode()));
	}

	@Override
	public Product addProduct(Product product) {
//		Product savedProduct = productRepository.save(product);
//		inventoryService.addProductData(savedProduct);
//		return savedProduct;
	    Product savedProduct = productRepository.findByProductName(product.getProductName()).orElse(null);
	    if (savedProduct == null) {
	        productRepository.save(product);
	        inventoryService.addProductData(product);
	        return product;
	    } else {
	        throw new ProductAlreadyExistsException("Product pehle se hi registered hai yaar!!", ErrorCodes.DATA_ALREADY_EXISTS.getCode());
	    }
	}

	@Override
	public Product updateProductData(Product product) {
//		return productRepository.save(product);

		Product existingCustomer = productRepository.findById(product.getId()).orElse(null);
		if (existingCustomer == null)
			throw new NoSuchProductExistsException("No Such Customer exists!!", ErrorCodes.DATA_NOT_FOUND.getCode());
		else {
			existingCustomer.setProductName(product.getProductName());
			existingCustomer.setDescription(product.getDescription());
			productRepository.save(existingCustomer);
			return product;
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
