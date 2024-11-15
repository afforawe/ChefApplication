package com.example.chef.model.dto;

import lombok.*;
import java.util.List;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class SaladDto {

    private Long id;
    private String name;
    private BigDecimal weight;
    private BigDecimal calories;
}
