package com.example.chef.controller;


import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/compositions")
public class SaladCompositionController {

    private final ChefFacade facade;

    @PostMapping("/compositions")
    public SaladDto createSaladComposition(@RequestParam(name = "saladId") Long saladId,
                                           @RequestBody SaladCompositionCreateDto dto) {
        return facade.createSaladComposition(saladId, dto);
    }

    @PostMapping("/compositions/list")
    public SaladDto createSaladComposition(@RequestParam Long saladId,
                                           @RequestBody List<SaladCompositionCreateDto> list) {
        return facade.createSaladComposition(saladId, list);
    }
}
