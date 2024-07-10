package com.velocity.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.inventory.model.MasterProduct;

public interface MasterProductRepository extends JpaRepository<MasterProduct, Long> {

	MasterProduct findByProductId(Long productId);
}
