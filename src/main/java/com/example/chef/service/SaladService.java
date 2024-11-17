package com.example.chef.service;

import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface SaladService extends BaseService<Salad> {

    Page<Salad> findByCaloriesRange (BigDecimal minCalories, BigDecimal maxCalories, Pageable pageable);

    boolean existsById(Long id);

    void deleteSaladByName(String saladName);

    Salad save(Long id, SaladComposition entity);

    Salad save(Long saladId, List<SaladComposition> list);
}
