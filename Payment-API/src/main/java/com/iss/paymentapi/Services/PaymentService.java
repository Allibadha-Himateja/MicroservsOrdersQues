package com.iss.paymentapi.Services;

import com.iss.paymentapi.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @KafkaListener(topics = "ProceedToPayment")
    public void makePayment(Order order)
    {
        System.out.println("Payment processing for Order ID: " + order.toString());
        confirmPayment(order);
    }
    private void confirmPayment(Order order)
    {
        kafkaTemplate.send("PaymentConfirmed",order);
    }
}
