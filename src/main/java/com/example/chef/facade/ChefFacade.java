package com.example.chef.facade;

import com.example.chef.model.dto.PageDto;
import com.example.chef.model.dto.SaladCompositionDto;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.SaladUpdateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;
import com.example.chef.model.entity.SaladComposition;

import java.math.BigDecimal;
import java.util.List;

public interface ChefFacade {

    //---Vegetable---

    VegetableDto findVegetableById(Long id);

    List<VegetableDto> findAllVegetables(PageDto dto);

    VegetableDto updateVegetable(VegetableUpdateDto dto);

    VegetableDto createVegetable(VegetableCreateDto dto);

    void removeVegetable(Long id);

    void deleteVegetableByName(String vegetableName);

    //---Salad---


    SaladDto findSaladById(Long id);

    List<SaladDto> findAllSalads(PageDto dto);

    List<SaladDto> findSaladsByCaloriesRange(BigDecimal minCalories, BigDecimal maxCalories, PageDto dto);

    SaladDto updateSalad(SaladUpdateDto dto);

    SaladDto createSalad(SaladCreateDto dto);

    void removeSalad(Long id);

    void deleteSaladByName(String saladName);

    //---SaladComposition---

    List<SaladCompositionDto> findAllSaladCompositions(Long saladId, PageDto dto);

    SaladDto createSaladComposition(Long id, SaladCompositionCreateDto dto);

    SaladDto createSaladComposition(Long id, List<SaladCompositionCreateDto> list);

}
