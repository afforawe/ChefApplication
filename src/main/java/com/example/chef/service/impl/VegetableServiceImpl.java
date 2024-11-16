package com.example.chef.service.impl;

import com.example.chef.converter.VegetableConverter;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.repository.VegetableRepository;
import com.example.chef.service.VegetableService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository repository;
    private final VegetableConverter vegetableConverter;


    @Override
    public Page<Vegetable> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Vegetable findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Vegetable not found by id: " + id));
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return repository.save(vegetable);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteVegetableByName(String vegetableName) {
        Vegetable vegetable = repository.findByName(vegetableName).orElseThrow(
                () -> new EntityNotFoundException("Vegetable not found by name: " + vegetableName)
        );

        repository.delete(vegetable);
    }
}
