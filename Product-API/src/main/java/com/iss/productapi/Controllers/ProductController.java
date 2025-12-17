package com.iss.productapi.Controllers;


import com.iss.productapi.Models.Product;
import com.iss.productapi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public void buyProduct(@RequestBody Product p){
        productService.buyProduct(p);
    }
}
