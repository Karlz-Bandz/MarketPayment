package com.izzisoft.kafka;

import com.izzisoft.payment.model.PaymentStatus;

public record OrderStatusEvent(
        Long orderId,
        PaymentStatus paymentStatus
) {
}
