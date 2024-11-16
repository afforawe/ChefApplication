package com.example.chef.facade;

import com.example.chef.model.dto.PageDto;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.SaladUpdateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;

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

    SaladDto updateSalad(SaladUpdateDto dto);

    SaladDto createSalad(SaladCreateDto dto);

    void removeSalad(Long id);

    void deleteSaladByName(String saladName);

    //---SaladComposition---

    SaladDto createSaladComposition(Long id, SaladCompositionCreateDto dto);

    SaladDto createSaladComposition(Long id, List<SaladCompositionCreateDto> list);

}
