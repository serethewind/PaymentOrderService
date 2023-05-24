package com.serethewind.paymentSolution.service.serviceImpl;

import com.serethewind.paymentSolution.dto.OrderRequest;
import com.serethewind.paymentSolution.dto.OrderResponse;
import com.serethewind.paymentSolution.entity.Order;
import com.serethewind.paymentSolution.entity.Payment;
import com.serethewind.paymentSolution.exception.PaymentException;
import com.serethewind.paymentSolution.repository.OrderRepository;
import com.serethewind.paymentSolution.repository.PaymentRepository;
import com.serethewind.paymentSolution.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional(rollbackOn = PaymentException.class)
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        order.setStatus("INPROGRESS");
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type does not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        return OrderResponse.builder().
                orderTrackingNUmber(order.getOrderTrackingNumber())
                .status(order.getStatus())
                .message("SUCCESS")
                .build();
    }
}
