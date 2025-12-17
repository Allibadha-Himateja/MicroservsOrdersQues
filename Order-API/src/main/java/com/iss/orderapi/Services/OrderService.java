package com.iss.orderapi.Services;

import com.iss.orderapi.Models.Order;
import com.iss.orderapi.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaTemplate<String,Order> kafkaTemplate;

    @KafkaListener(topics = "BuyProduct")
    public void createOrder(Product product)
    {
        System.out.println("Received BuyProduct Event"+product.toString());
        Order order=Order.builder().orderId(1).productId(product.getId()).status(false).build();
        proceedToPayment(order);
    }

    public void proceedToPayment(Order order)
    {
        kafkaTemplate.send("ProceedToPayment",order);
    }

    @KafkaListener(topics = "PaymentConfirmed")
    public void ConfirmOrder(Order order)
    {
        order.setStatus(true);
        kafkaTemplate.send("ValidateOrder",order);
    }
}
