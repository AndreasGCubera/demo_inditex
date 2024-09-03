package com.example.demo.service;

import com.example.demo.model.Price;
import com.example.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getApplicablePrice(int brandId, int productId, LocalDateTime startDate) {
        List<Price> prices = priceRepository.findApplicablePrices(brandId, productId, startDate);
        return prices.isEmpty() ? null : prices.get(0);
    }
}