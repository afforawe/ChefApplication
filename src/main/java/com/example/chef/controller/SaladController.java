package com.example.chef.controller;

import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.create.SaladCompositionCreateDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/salads")
public class SaladController {

    private final ChefFacade facade;

    @GetMapping
    public SaladDto findOneSalad(@RequestParam Long id) {
        return facade.findOneSalad(id);
    }

    @PostMapping
    public SaladDto createSalad(@RequestBody SaladCreateDto dto) {
        return facade.createSalad(dto);
    }

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