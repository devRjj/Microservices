package com.velocity.product.service;

import java.util.List;

import com.velocity.product.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long Id);

	Product addProduct(Product product);

	Product updateProductData(Product product);

	void deleteProduct(Long id);

}
