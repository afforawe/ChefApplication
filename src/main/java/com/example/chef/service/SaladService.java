package com.example.chef.service;

import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;

import java.util.List;

public interface SaladService extends BaseService<Salad> {

    boolean existsById(Long id);

    void deleteSaladByName(String saladName);

    Salad save(Long id, SaladComposition entity);

    Salad save(Long saladId, List<SaladComposition> list);
}
