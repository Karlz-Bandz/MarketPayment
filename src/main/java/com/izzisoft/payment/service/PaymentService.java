package com.izzisoft.payment.service;

import com.izzisoft.payment.dto.PaymentRequest;
import com.izzisoft.payment.dto.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        if ("FAIL".equals(paymentRequest.paymentMethod())) {
            return new PaymentResponse(paymentRequest.orderId(), "FAILED");
        }

        return new PaymentResponse(paymentRequest.orderId(), "SUCCESS");
    }
}
