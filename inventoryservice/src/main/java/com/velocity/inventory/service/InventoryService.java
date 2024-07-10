package com.velocity.inventory.service;

import com.velocity.inventory.model.MasterProduct;
import com.velocity.inventory.model.Product;

public interface InventoryService {
	
	MasterProduct addProductData(Product product );
	
	MasterProduct getProductDetailsById(Long productId);

	MasterProduct reduceQty(Long productId, Integer qty);
}
