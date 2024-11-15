package com.example.chef.converter;

import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.entity.Salad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaladConverter {

    SaladDto convert(Salad source);

    List<SaladDto> convert(List<Salad> source);
}
