package com.example.chef.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaladCompositionDto {

    private Long id;
    private SaladDto salad;
    private VegetableDto vegetable;
    private BigDecimal weight;
    private BigDecimal calories;
}
