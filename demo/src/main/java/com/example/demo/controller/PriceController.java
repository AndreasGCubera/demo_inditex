package com.example.demo.controller;

import com.example.demo.model.Price;
import com.example.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/all")
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @GetMapping("/price")
    public ResponseEntity<Price> getPrice(
            @RequestParam("brandId") int brandId,
            @RequestParam("productId") int productId,
            @RequestParam("startDate") LocalDateTime startDate
            ) {

        Price price = priceService.getApplicablePrice(brandId, productId, startDate);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Inditex!";
    }
}
