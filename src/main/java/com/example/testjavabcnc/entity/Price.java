package com.example.testjavabcnc.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Entity
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Price {
    public Price() {
    }
    

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Valid
    private Integer brand_id;

    @NotNull
    @Valid
    private LocalDateTime start_date,end_date;

    @NotNull
    @Valid
    private Integer price_list,product_id,priority;

    @NotNull
    @Valid
    private String curr;

    @NotNull
    @Valid
    private Double price;

    public Price(int brand_id, LocalDateTime start_date, LocalDateTime end_date, Integer price_list, Integer product_id, Integer priority, String curr, Double price) {
        this.brand_id = brand_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price_list = price_list;
        this.product_id = product_id;
        this.priority = priority;
        this.curr = curr;
        this.price = price;
    }

    public void setLast_update_by(String string) {
    }
}
