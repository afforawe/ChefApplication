package com.example.chef.service;

import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable findById(Long id);

    List<Vegetable> findAllVegetable();

    VegetableDto createVegetable(VegetableCreateDto entity);

    void deleteVegetable(Long id);

    void deleteVegetableByName(String vegetableName);

}