package com.velocity.order.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.velocity.order.model.PaymentRequest;

@FeignClient(value = "PAYMENT-SERVICE",url = "http://localhost:8083/api/payments")
public interface PaymentService {
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
