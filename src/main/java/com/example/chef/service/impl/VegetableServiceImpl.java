package com.example.chef.service.impl;

import com.example.chef.converter.VegetableConverter;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.repository.VegetableRepository;
import com.example.chef.service.VegetableService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository repository;
    private final VegetableConverter vegetableConverter;

    @Override
    public List<Vegetable> findAllVegetable() {
        return repository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Vegetable not found by id: " + id));
    }

    @Override
    public Vegetable save(Vegetable entity) {
        return repository.save(entity);
    }

    public void deleteVegetable(Long id) {
        repository.deleteById(id);
    }
}
