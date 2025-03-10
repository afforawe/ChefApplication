package com.example.chef.model.dto.update;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VegetableUpdateDto {

    private Long id;
    private String name;
    private BigDecimal caloriesOneHundred;
}
