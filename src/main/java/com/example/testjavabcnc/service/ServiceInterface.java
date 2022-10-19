package com.example.testjavabcnc.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.testjavabcnc.entity.Price;
import com.example.testjavabcnc.entity.PriceResponse;

public interface ServiceInterface {
    public List<PriceResponse> getAllPricesWith(LocalDateTime date, Integer productId, Integer brandId);
}
