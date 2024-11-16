package com.example.chef.converter;

import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.update.SaladUpdateDto;

import com.example.chef.model.entity.Salad;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaladConverter {

    SaladDto convert(Salad source);

    Salad convert(SaladCreateDto source);

    List<SaladDto> convert(List<Salad> source);

    Salad convert(@MappingTarget Salad target, SaladUpdateDto source);
}
