package com.example.chef.facade.impl;

import com.example.chef.converter.SaladCompositionConverter;
import com.example.chef.converter.SaladConverter;
import com.example.chef.converter.VegetableConverter;
import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.PageDto;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.SaladUpdateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;
import com.example.chef.model.entity.Salad;
import com.example.chef.model.entity.SaladComposition;
import com.example.chef.model.entity.Vegetable;
import com.example.chef.service.SaladService;
import com.example.chef.service.VegetableService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ChefFacadeImpl implements ChefFacade {

    private final VegetableService vegetableService;
    private final SaladService saladService;
    private final VegetableConverter vegetableConverter;
    private final SaladConverter saladConverter;
    private final SaladCompositionConverter saladCompositionConverter;

    //---Vegetable---

    @Override
    public VegetableDto findVegetableById(Long id) {
        return vegetableConverter.convert(vegetableService.findById(id));
    }

    @Override
    public List<VegetableDto> findAllVegetables(PageDto dto) {
        Pageable pageable = PageRequest.of(
                dto.getPageNumber(),
                dto.getPageSize(),
                dto.getSortOrder().equals("asc")
                        ? Sort.by(dto.getSortField()).ascending()
                        : Sort.by(dto.getSortField()).descending());

        return vegetableConverter.convert(vegetableService.findAll(pageable).getContent());
    }

    @Override
    public VegetableDto updateVegetable(VegetableUpdateDto dto) {
        Vegetable vegetable = vegetableConverter.convert(vegetableService.findById(dto.getId()), dto);
        return vegetableConverter.convert(vegetableService.save(vegetable));
    }

    public VegetableDto createVegetable(VegetableCreateDto dto) {
        return vegetableConverter.convert(vegetableService.save(vegetableConverter.convert(dto)));
    }

    @Override
    public void deleteVegetableByName(String vegetableName) {
        vegetableService.deleteVegetableByName(vegetableName);
    }

    @Override
    public void removeVegetable(Long id) {
        vegetableService.remove(id);
    }

    //---Salad---

    @Override
    public SaladDto findSaladById(Long id) {
        return saladConverter.convert(saladService.findById(id));
    }

    @Override
    public List<SaladDto> findAllSalads(PageDto dto) {
        Pageable pageable = PageRequest.of(
                dto.getPageNumber(),
                dto.getPageSize(),
                dto.getSortOrder().equals("asc")
                        ? Sort.by(dto.getSortField()).ascending()
                        : Sort.by(dto.getSortField()).descending());

        return saladConverter.convert(saladService.findAll(pageable).getContent());
    }

    @Override
    public SaladDto createSalad(SaladCreateDto dto) {
        return saladConverter.convert(saladService.save(saladConverter.convert(dto)));
    }

    @Override
    public SaladDto updateSalad(SaladUpdateDto dto) {
        Salad salad = saladConverter.convert(saladService.findById(dto.getId()), dto);
        return saladConverter.convert(saladService.save(salad));
    }

    @Override
    public void removeSalad(Long id) {
        saladService.remove(id);
    }

    @Override
    public void deleteSaladByName(String saladName) {
        saladService.deleteSaladByName(saladName);
    }

    //---SaladComposition---

    @Override
    public SaladDto createSaladComposition(Long saladId, SaladCompositionCreateDto dto) {
        if (saladService.existsById(saladId)) {
            SaladComposition composition = saladCompositionConverter.convert(dto);
            return saladConverter.convert(saladService.save(saladId, composition));
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
