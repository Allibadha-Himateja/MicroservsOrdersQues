package com.iss.productapi.Services;

import com.iss.productapi.Models.Order;
import com.iss.productapi.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private KafkaTemplate<String,Product> kafkaTemplate;

    public Product buyProduct(Product p){
        kafkaTemplate.send("BuyProduct",p);
        return p;
    }

    @KafkaListener(topics = "ValidateOrder")
    public void ValidateOrder(Order o)
    {
        System.out.println("Order Created and payment Confirmed"+o.toString());
    }
}
