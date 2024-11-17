package com.example.chef.service.impl;

import com.example.chef.model.entity.SaladComposition;
import com.example.chef.repository.SaladCompositionRepository;
import com.example.chef.repository.VegetableRepository;
import com.example.chef.service.SaladCompositionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Service
public class SaladCompositionServiceImpl implements SaladCompositionService {

    private SaladCompositionRepository saladCompositionRepository;
    private VegetableRepository vegetableRepository;

    @Override
    public Page<SaladComposition> findAllBySaladId(Long saladId, Pageable pageable) {
        return saladCompositionRepository.findAllBySaladId(saladId, pageable);
    }

}
