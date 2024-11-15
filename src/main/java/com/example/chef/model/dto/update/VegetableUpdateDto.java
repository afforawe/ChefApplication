package com.example.chef.model.dto.update;

import com.example.chef.model.dto.create.VegetableCreateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VegetableUpdateDto extends VegetableCreateDto {

    private Long id;
}
