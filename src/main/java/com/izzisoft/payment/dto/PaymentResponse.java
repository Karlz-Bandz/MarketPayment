package com.izzisoft.payment.dto;

public record PaymentResponse(
        Long orderId,
        String status
) {
}
