package com.izzisoft.payment.controller;

import com.izzisoft.payment.dto.PaymentRequest;
import com.izzisoft.payment.dto.PaymentResponse;
import com.izzisoft.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(paymentService.processPayment(paymentRequest), HttpStatus.CREATED);
    }
}
