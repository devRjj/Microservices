package com.velocity.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.order.model.Order;
import com.velocity.order.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order Controller", description = "APIs for order Service")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@Operation(summary = "Get the order details")
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderDetail(@PathVariable Long id) {
		LOG.info("Fetching order with ID: {}", id);
		Order order = orderService.getOrderDetail(id);
		if (order != null) {
			return new ResponseEntity<>(order, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Adding new order")
	@PostMapping
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		LOG.info("Adding new order");
		Order newOrder = orderService.placeOrder(order);
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}

}
