package com.example.chef.model.dto;

import lombok.*;
import java.util.List;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SaladDto {

    private Long id;
    private String name;
    private BigDecimal weight;
    private BigDecimal calories;
    private List<SaladCompositionDto> compositions;
}
