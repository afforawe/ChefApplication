package com.example.chef.service;

import com.example.chef.model.entity.SaladComposition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaladCompositionService {


    Page<SaladComposition> findAllBySaladId(Long saladId, Pageable pageable);
}
