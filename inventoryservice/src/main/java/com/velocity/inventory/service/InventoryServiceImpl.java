package com.velocity.inventory.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.velocity.inventory.config.ProductService;
import com.velocity.inventory.model.MasterProduct;
import com.velocity.inventory.model.Product;
import com.velocity.inventory.repo.MasterProductRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private final MasterProductRepository masterProductRepository;
	private final ProductService productService;

	public InventoryServiceImpl(MasterProductRepository masterProductRepository, ProductService productService) {
		this.masterProductRepository = masterProductRepository;
		this.productService = productService;
	}

	@Override
	public MasterProduct getProductDetailsById(Long productId) {
		MasterProduct productInfo = masterProductRepository.findByProductId(productId);
		return productInfo;
	}

	@Override
	@Transactional
	public MasterProduct reduceQty(Long productId, Integer qty) {
		MasterProduct productInfo = masterProductRepository.findByProductId(productId);
		Integer totalQty = productInfo.getQuantity();
		if (qty > totalQty) {
			throw new RuntimeException("Product is out of stock/Required Qty is not availablel̥");
		}
		Integer newQty = totalQty.intValue() - qty.intValue();

		productInfo.setQuantity(newQty);
		MasterProduct revisedProduct = masterProductRepository.save(productInfo);

		Product productData = productService.getProductById(productId).getBody();
		productData.setQuantity(newQty);
		productService.updateProduct(productId, productData);
		return revisedProduct;
	}

	@Override
	public MasterProduct addProductData(Product product) {
		MasterProduct masterProduct = new MasterProduct();
		masterProduct.setProductId(product.getId());
		masterProduct.setProductName(product.getProductName());
		masterProduct.setProductPrice(product.getProductPrice());
		masterProduct.setQuantity(product.getQuantity());
		masterProduct.setDescription(product.getDescription());
		return masterProductRepository.save(masterProduct);
	}

}
