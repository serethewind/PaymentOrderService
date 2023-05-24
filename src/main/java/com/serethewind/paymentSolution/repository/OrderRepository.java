package com.serethewind.paymentSolution.repository;

import com.serethewind.paymentSolution.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
