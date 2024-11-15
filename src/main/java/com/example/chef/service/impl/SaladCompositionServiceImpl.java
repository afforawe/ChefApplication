package com.example.chef.service.impl;

import com.example.chef.model.entity.SaladComposition;
import com.example.chef.repository.SaladCompositionRepository;
import com.example.chef.service.SaladCompositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaladCompositionServiceImpl implements SaladCompositionService {

    private SaladCompositionRepository repository;

    @Override
    public List<SaladComposition> findBySalad(Long saladId) {
        return repository.findAllBySaladId(saladId);
    }
}
