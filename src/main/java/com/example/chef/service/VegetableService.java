package com.example.chef.service;

import com.example.chef.model.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable findById(Long id);

    List<Vegetable> findAllVegetable();

    Vegetable save(Vegetable entity);

    void deleteVegetable(Long id);

}