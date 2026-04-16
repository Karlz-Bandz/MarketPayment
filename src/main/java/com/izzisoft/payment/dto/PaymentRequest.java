package com.izzisoft.payment.dto;

import java.math.BigDecimal;

public record PaymentRequest(
        Long orderId,
        BigDecimal amount,
        String paymentMethod
) {
}
