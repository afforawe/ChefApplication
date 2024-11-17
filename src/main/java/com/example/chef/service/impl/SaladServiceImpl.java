package com.example.chef.service.impl;

import com.example.chef.converter.SaladCompositionConverter;
import com.example.chef.converter.SaladConverter;
import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.repository.SaladCompositionRepository;
import com.example.chef.repository.SaladRepository;
import com.example.chef.repository.VegetableRepository;
import com.example.chef.repository.specification.SaladSpecification;
import com.example.chef.service.SaladService;
import com.example.chef.util.CaloriesUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@AllArgsConstructor
@Service
public class SaladServiceImpl implements SaladService {

    private final SaladRepository saladRepository;
    private final VegetableRepository vegetableRepository;
    private final SaladCompositionRepository saladCompositionRepository;
    private final SaladCompositionConverter saladCompositionConverter;
    private final SaladConverter saladConverter;

    @Override
    public boolean existsById(Long id) {
        return saladRepository.existsById(id);
    }

    @Override
    public Salad findById(Long id) {
        return saladRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Salad not found with id: " + id)
        );
    }

    @Override
    public Salad save(Salad salad) {
        if (salad.getCalories() == null && salad.getWeight() == null) {
            salad.setWeight(BigDecimal.ZERO);
            salad.setCalories(BigDecimal.ZERO);
        }
        return saladRepository.save(salad);
    }

    @Override
    public Page<Salad> findAll(Pageable pageable) {
        return saladRepository.findAll(pageable);
    }

    @Override
    public Page<Salad> findByCaloriesRange(BigDecimal minCalories, BigDecimal maxCalories, Pageable pageable) {
        Specification<Salad> specification = SaladSpecification.findByCaloriesRange(minCalories, maxCalories);
        return saladRepository.findAll(specification, pageable);
    }

    @Override
    public void remove(Long id) {
        saladRepository.deleteById(id);
    }

    @Override
    public void deleteSaladByName(String saladName) {
        Salad salad = saladRepository.findByName(saladName).orElseThrow(
                () -> new EntityNotFoundException("Salad not found with name: " + saladName)
        );
        saladRepository.delete(salad);
    }

    @Override
    public Salad save(Long saladId, SaladComposition composition) {
        Salad salad = findById(saladId);

        Vegetable vegetable = vegetableRepository.findById(composition.getVegetableId()).orElseThrow(
                () -> new RuntimeException("Vegetable not found with id: " + composition.getVegetableId())
        );

        var compositionOptional = saladCompositionRepository.findBySaladIdAndVegetableId(saladId, vegetable.getId());
        if (compositionOptional.isPresent()) {
            var compositionExists = compositionOptional.get();
            compositionExists.setWeight(compositionExists.getWeight().add(composition.getWeight()));
            compositionExists.setCalories(CaloriesUtils.caloriesCount(vegetable.getCaloriesOneHundred(), compositionExists.getWeight()));
            saladCompositionRepository.save(compositionExists);
        } else {
            composition.setSaladId(saladId);
            composition.setSalad(salad);
            composition.setVegetable(vegetable);
            composition.setCalories(CaloriesUtils.caloriesCount(vegetable.getCaloriesOneHundred(), composition.getWeight()));
            saladCompositionRepository.save(composition);
        }

        var compositionList = saladCompositionRepository.findAllBySaladId(saladId);

        BigDecimal weight = new BigDecimal(BigInteger.ZERO);
        for (SaladComposition item : compositionList) {
            weight = weight.add(item.getWeight());
        }
        salad.setWeight(weight);

        BigDecimal calories = new BigDecimal(BigInteger.ZERO);
        for (SaladComposition item : compositionList) {
            calories = calories.add(item.getCalories());
        }
        salad.setCalories(calories);
        return saladRepository.save(salad);
    }

    @Override
    public Salad save(Long saladId, List<SaladComposition> list) {
        for (SaladComposition item : list) {
            save(saladId, item);
        }
        return findById(saladId);
    }
}