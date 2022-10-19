package com.example.testjavabcnc.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PriceResponse {
    @ApiModelProperty(notes = "Foreing key brand id", required = true)
    public Integer brand_id;
    @ApiModelProperty(notes="price list", required = true)
    public Integer price_list;
    @ApiModelProperty(notes="id of the product", required = true)
    public Integer product_id;
    @ApiModelProperty(notes="start date of the price", required = true)
    public LocalDateTime start_date;
    @ApiModelProperty(notes="price of the product", required = true)
    public Double price;
}
