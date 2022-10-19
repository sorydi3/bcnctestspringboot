package com.example.testjavabcnc.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testjavabcnc.entity.Price;
import com.example.testjavabcnc.entity.PriceResponse;
import com.example.testjavabcnc.repository.EcomerceH2reposiory;

@Service
public class MyService implements ServiceInterface {

        @Autowired
         ModelMapper modelMapper;

        @Autowired
        private EcomerceH2reposiory ecomerceH2reposiory;
        /**
         * 
         * @param date
         * @param productId
         * @param brandId
         * 
         * @return List<Price> filtered by date, productId and brandId
         */

        @Override
        public List<PriceResponse> getAllPricesWith(LocalDateTime date, Integer productId, Integer brandId) {
                System.out.println("date: " + date + " productId: " + productId + " brandId: " + brandId);
               List<Price> list = ((List<Price>) ecomerceH2reposiory.findAll()).stream()
                                .filter(price -> price.getProduct_id().equals(productId))
                                .filter(price -> price.getBrand_id().equals(brandId))
                                .filter(price -> price.getStart_date().isEqual(date))
                                .collect(Collectors.toList());
                return list.stream().map(price -> modelMapper.map(price, PriceResponse.class)).collect(Collectors.toList());
        }
        /**
         * 
         * @return List<Price> all prices
         */
        public List<Price> getAllPrices() {
                return (List<Price>) ecomerceH2reposiory.findAll();
        }
    
}

