package com.velocity.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.payment.model.PaymentRequest;
import com.velocity.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Payment Controller", description = "APIs for managing payment")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	@Operation(summary = "do payment for payment specifications")
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		return new ResponseEntity<Long>(paymentService.doPayment(paymentRequest),HttpStatus.OK);
	}

}
