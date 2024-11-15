package com.example.chef.facade.impl;

import com.example.chef.converter.SaladCompositionConverter;
import com.example.chef.converter.SaladConverter;
import com.example.chef.converter.VegetableConverter;
import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;
import com.example.chef.model.entity.SaladComposition;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.service.SaladService;
import com.example.chef.service.VegetableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ChefFacadeImpl implements ChefFacade {

    private final VegetableService vegetableService;
    private final VegetableConverter vegetableConverter;
    private final SaladService saladService;
    private final SaladCompositionConverter saladCompositionConverter;
    private final SaladConverter saladConverter;

    @Override
    public VegetableDto findOneVegetable(Long id) {
        return vegetableConverter.convert(vegetableService.findById(id));
    }

    @Override
    public List<VegetableDto> findAllVegetable() {
        return vegetableConverter.convert(vegetableService.findAllVegetable());
    }

    @Override
    public VegetableDto createVegetable(Long vegetableId, VegetableCreateDto dto) {
        if (saladService.existsById(vegetableId)) {
            Vegetable vegetable = vegetableConverter.convert(dto);
            return vegetableConverter.convert(vegetableService.save(vegetable));
        }
        throw new RuntimeException("Vegetable already exists");
    }

    @Override
    public void removeVegetable(Long id) {
        if (saladService.existsById(id)){
            throw new RuntimeException("Vegetable not found");
        }
        vegetableService.deleteVegetable(id);
    }

    //---

    @Override
    public SaladDto findOneSalad(Long id) {
        return null;
    }

    @Override
    public SaladDto createSalad(SaladCreateDto dto) {
        return null;
    }

    //---

    @Override
    public SaladDto createSaladComposition(Long saladId, SaladCompositionCreateDto dto) {
        if (saladService.existsById(saladId)) {
            SaladComposition composition = saladCompositionConverter.convert(dto);
            return saladConverter.convert(
                    saladService.save(saladId, composition)
            );
        }
        throw new RuntimeException("Salad already exist");
    }

    @Override
    public SaladDto createSaladComposition(Long saladId, List<SaladCompositionCreateDto> list) {

        if (list.isEmpty()) {
            //todo
        }
        if (saladService.existsById(saladId)) {
            list.forEach(dto -> dto.setSaladId(saladId));
            List<SaladComposition> compositionList = list.stream().map(saladCompositionConverter::convert).toList();
            return saladConverter.convert(saladService.save(saladId, compositionList));
        }
        throw new RuntimeException("Salad composition not found");
    }
}
