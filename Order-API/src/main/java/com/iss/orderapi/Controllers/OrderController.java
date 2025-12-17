package com.iss.orderapi.Controllers;

import com.iss.orderapi.Models.Product;
import com.iss.orderapi.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody Product product)
    {
        orderService.createOrder(product);
    }
}
