package com.example.chef.service;

import com.example.chef.model.entity.Vegetable;

public interface VegetableService extends BaseService<Vegetable> {

    void deleteVegetableByName(String vegetableName);

}