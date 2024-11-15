package com.example.chef.service.impl;

import com.example.chef.converter.SaladCompositionConverter;
import com.example.chef.converter.SaladConverter;
import com.example.chef.model.dto.SaladCompositionDto;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.repository.SaladCompositionRepository;
import com.example.chef.repository.SaladRepository;
import com.example.chef.repository.VegetableRepository;
import com.example.chef.service.SaladService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
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
    public Salad findOne(Long id) {
        return saladRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("qwertyui")
        );
    }

    @Override
    public SaladDto findByName(String saladName) {

        Salad salad = saladRepository.findByName(saladName).orElseThrow(
                () -> new EntityNotFoundException("Salad not found with name: " + saladName)
        );

        List<SaladComposition> compositions = saladCompositionRepository.findAllBySaladId(salad.getId());
        List<SaladCompositionDto> compositionDto = compositions.stream()
                .map(saladCompositionConverter::convert)
                .toList();
        SaladDto saladDto = saladConverter.convert(salad);
        saladDto.setCompositions(compositionDto);
        return saladDto;
    }

    @Override
    public Salad save(Salad entity) {
        return saladRepository.save(entity);
    }

    @Override
    public Salad save(Long saladId, SaladComposition composition) {
        Salad salad = findOne(saladId);

        Vegetable vegetable = vegetableRepository.findById(composition.getVegetableId()).orElseThrow(
                () -> new RuntimeException("qwertyu")
        );

        var compositionOptional = saladCompositionRepository.findBySaladIdAndVegetableId(saladId, vegetable.getId());
        if (compositionOptional.isPresent()) {
            var compositionExists = compositionOptional.get();
            compositionExists.setWeight(compositionExists.getWeight().add(composition.getWeight()));
            compositionExists.setCalories(caloriesCount(vegetable.getCaloriesOneHundred(), compositionExists.getWeight()));
            saladCompositionRepository.save(compositionExists);
        } else {
            composition.setSaladId(saladId);
            composition.setSalad(salad);
            composition.setVegetable(vegetable);
            composition.setCalories(caloriesCount(vegetable.getCaloriesOneHundred(), composition.getWeight()));
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
        return findOne(saladId);
    }

    private BigDecimal caloriesCount(BigDecimal caloriesOneHundred, BigDecimal weight) {
        var div = new BigDecimal("100");
        BigDecimal result = caloriesOneHundred.multiply(weight);
        return result.divide(div);
    }
}