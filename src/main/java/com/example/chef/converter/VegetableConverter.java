package com.example.chef.converter;

import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.entity.Vegetable;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VegetableConverter {

    VegetableDto convert(Vegetable source);

    Vegetable convert(VegetableCreateDto source);

    List<VegetableDto> convert(List<Vegetable> source);

}