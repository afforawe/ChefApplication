package com.example.chef.service;

import com.example.chef.model.entity.SaladComposition;

import java.util.List;

public interface SaladCompositionService {

    List<SaladComposition> findBySalad(Long id);
}
