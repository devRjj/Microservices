package com.velocity.order.service;

import com.velocity.order.model.Order;

public interface OrderService {

	Order getOrderDetail(Long id);

	Order placeOrder(Order order);

}
