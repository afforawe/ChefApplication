package com.example.chef.converter;

import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.entity.SaladComposition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaladCompositionConverter {

    SaladComposition convert(SaladCompositionCreateDto source);
}
