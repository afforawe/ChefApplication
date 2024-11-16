package com.example.chef.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SaladDto {

    private Long id;
    private String name;
    private BigDecimal weight;
    private BigDecimal calories;
}
