package com.example.chef.converter;

import com.example.chef.model.dto.SaladCompositionDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.entity.SaladComposition;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaladCompositionConverter {

    SaladComposition convert(SaladCompositionCreateDto source);

    SaladCompositionDto convert(SaladComposition source);

    List<SaladCompositionDto> convert(List<SaladComposition> source);
}
