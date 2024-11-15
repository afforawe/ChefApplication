package com.example.chef.model.dto.create;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaladCompositionCreateDto {

    private Long id;
    private Long saladId;
    private Long vegetableId;
    private BigDecimal weight;
}
