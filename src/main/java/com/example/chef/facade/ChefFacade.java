package com.example.chef.facade;

import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;

import java.util.List;

public interface ChefFacade {

    VegetableDto findOneVegetable(Long id);

    List<VegetableDto> findAllVegetable();

    VegetableDto createVegetable(Long vegetableId, VegetableCreateDto dto);

    void removeVegetable(Long id);

    //---

    SaladDto findOneSalad(Long id);

    SaladDto createSalad(SaladCreateDto dto);

    //---

    SaladDto createSaladComposition(Long id, SaladCompositionCreateDto dto);

    SaladDto createSaladComposition(Long id, List<SaladCompositionCreateDto> list);

}
