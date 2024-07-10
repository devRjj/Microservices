package com.velocity.payment.service;

import com.velocity.payment.model.PaymentRequest;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);

}
