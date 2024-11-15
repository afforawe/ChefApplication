package com.example.chef.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class VegetableDto {

    private Long id;
    private String name;
    private BigDecimal caloriesOneHundred;
}
