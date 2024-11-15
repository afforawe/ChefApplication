package com.example.chef.service;

import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;

import java.util.List;

public interface SaladService {

    boolean existsById(Long id);

    Salad findOne(Long id);

    Salad save(Salad entity);

    Salad save(Long id, SaladComposition entity);

    Salad save(Long saladId, List<SaladComposition> list);
}
