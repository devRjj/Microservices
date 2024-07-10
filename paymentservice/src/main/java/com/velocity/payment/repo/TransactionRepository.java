package com.velocity.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.payment.model.TransactionDetails;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {

}
