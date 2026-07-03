package com.izzisoft.payment.service;

import com.izzisoft.kafka.IncreaseProductEvent;
import com.izzisoft.kafka.OrderStatusEvent;
import com.izzisoft.kafka.PaymentEvent;
import com.izzisoft.payment.model.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Random rand = new Random();

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "payment", groupId = "payment-group")
    public void processPayment(PaymentEvent paymentEvent) {

        boolean success = rand.nextBoolean();

        if (success) {
            System.out.println("Payment success!");
            kafkaTemplate.send(
                    "order-payment-status",
                    new OrderStatusEvent(paymentEvent.orderId(), PaymentStatus.FINISHED));
        } else {
            IncreaseProductEvent increaseProductEvent = new IncreaseProductEvent(paymentEvent.productId(), paymentEvent.productsAmount());

            kafkaTemplate.send("product-increase", increaseProductEvent);
            kafkaTemplate.send(
                    "order-payment-status",
                    new OrderStatusEvent(paymentEvent.orderId(), PaymentStatus.CANCELED));

            System.out.println("Payment err!");
        }
    }
}
