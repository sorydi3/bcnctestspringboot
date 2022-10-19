package com.example.testjavabcnc.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponses;

import com.example.testjavabcnc.entity.PriceResponse;
import com.example.testjavabcnc.service.MyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


@RestController
@ApiResponses(value = {
  @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
  @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
  @ApiResponse(code=500, message = "The server is down. Please make sure that the Ecommerce server is running."),
  @ApiResponse(code=503, message = "The service is not available, please try again later."),
  @ApiResponse(code=200, message = "OK")
})

public class ControllerEPrice {
    @Autowired
    private MyService serviceInterface;
    @Autowired
    ModelMapper modelMapper;
    

    @GetMapping("/prices")
    @ApiOperation(value = "Get list of prices by start date ,product id and brand id ", notes = "Returns a list of prices by start date ,product id and brand id. Ex: brand_id = 1 ,start_date=2020-06-15T21:00:00,product_id=35455", response = PriceResponse.class, responseContainer = "List")
    public List<PriceResponse> getPrices(@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam(required = true) Integer productId,
            @RequestParam(required = true) Integer brandId) {
                System.out.println("date: " + date + " productId: " + productId + " brandId: " + brandId);
        return serviceInterface.getAllPricesWith(date, productId, brandId);
    }
    

    @GetMapping("/prices/all")
    @ApiOperation(value = "Get list of all prices ", notes = "Returns a list of all prices", response = PriceResponse.class, responseContainer = "List")
    public List<PriceResponse>  listOfPrices() {
        return serviceInterface.getAllPrices().stream().map(price -> modelMapper.map(price, PriceResponse.class)).collect(Collectors.toList());
    }
    
}
