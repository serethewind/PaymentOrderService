package com.serethewind.paymentSolution.service;

import com.serethewind.paymentSolution.dto.OrderRequest;
import com.serethewind.paymentSolution.dto.OrderResponse;
import org.springframework.stereotype.Service;


public interface OrderService {
 OrderResponse placeOrder (OrderRequest orderRequest);
}
