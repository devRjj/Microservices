package com.velocity.payment.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Service;

import com.velocity.payment.model.PaymentRequest;
import com.velocity.payment.model.TransactionDetails;
import com.velocity.payment.repo.TransactionRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final TransactionRepository repository;

	public PaymentServiceImpl(TransactionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Long doPayment(PaymentRequest paymentRequest) {
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setOrderId(paymentRequest.getOrderId());
		transactionDetails.setAmount(paymentRequest.getTotalAmount());
		transactionDetails.setPaymentMode(paymentRequest.getPaymentMode().name());
		transactionDetails.setPaymentStatus("SUCCESS");
		transactionDetails.setReferenceNumber(Random.from(RandomGenerator.getDefault()).toString());
		transactionDetails.setDate(LocalDateTime.now());

		TransactionDetails savedData = repository.save(transactionDetails);

		return savedData.getId();
	}

}
