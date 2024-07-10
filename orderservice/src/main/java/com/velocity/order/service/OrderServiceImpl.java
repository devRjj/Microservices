package com.velocity.order.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.velocity.order.config.InventoryService;
import com.velocity.order.config.PaymentService;
import com.velocity.order.config.ProductService;
import com.velocity.order.model.Order;
import com.velocity.order.model.PaymentMode;
import com.velocity.order.model.PaymentRequest;
import com.velocity.order.model.Product;
import com.velocity.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	private final ProductService productService;
	private final PaymentService paymentService;
	private final InventoryService inventoryService;

	public OrderServiceImpl(OrderRepository orderRepository, ProductService productService,
			PaymentService paymentService, InventoryService inventoryService) {
		this.orderRepository = orderRepository;
		this.productService = productService;
		this.paymentService = paymentService;
		this.inventoryService = inventoryService;
	}

	@Override
	public Order getOrderDetail(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public Order placeOrder(Order order) {
		ResponseEntity<Product> response = productService.getProductById(order.getProductId());
		Product product = response.getBody();
		BigDecimal totalamt = product.getProductPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
		order.setTotalPrice(totalamt);
		Order savedOrder = orderRepository.save(order);
		
		//Check for Inventry qty;
		
		// Payment
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(savedOrder.getId());
		paymentRequest.setTotalAmount(savedOrder.getTotalPrice());
		paymentRequest.setPaymentMode(PaymentMode.CASH);
		ResponseEntity<Long> paymentResponse = paymentService.doPayment(paymentRequest);
		Long paymentId = paymentResponse.getBody();
		if (paymentId != null) {
			inventoryService.reduceProductQuantity(product.getId(), savedOrder.getQuantity());
		}
		return savedOrder;
	}

}
