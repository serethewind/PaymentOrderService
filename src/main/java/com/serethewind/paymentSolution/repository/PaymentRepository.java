package com.serethewind.paymentSolution.repository;

import com.serethewind.paymentSolution.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
