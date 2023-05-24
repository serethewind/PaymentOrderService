package com.serethewind.paymentSolution.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private String orderTrackingNUmber;
    private String status;
    private String message;
}
