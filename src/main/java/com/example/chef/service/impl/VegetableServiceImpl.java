package com.example.chef.service.impl;

import com.example.chef.converter.VegetableConverter;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
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


    public VegetableDto createVegetable(VegetableCreateDto dto) {
        repository.findByName(dto.getName()).ifPresent(vegetable -> {
            throw new EntityExistsException("Vegetable " + dto.getName() + " already exists");
        });

        Vegetable vegetable = vegetableConverter.convert(dto);
        Vegetable saved = repository.save(vegetable);

        return vegetableConverter.convert(saved);
    }

    public void deleteVegetable(Long id) {
        repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Vegetable not found by id: " + id)
        );
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
