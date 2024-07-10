package com.velocity.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velocity.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
