package com.serethewind.paymentSolution.dto;

import com.serethewind.paymentSolution.entity.Order;
import com.serethewind.paymentSolution.entity.Payment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
private Order order;
private Payment payment;
}
