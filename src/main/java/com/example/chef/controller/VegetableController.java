package com.example.chef.controller;

import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vegetables")
public class VegetableController {

    private final ChefFacade facade;

    @GetMapping
    public VegetableDto findOneVegetable(@RequestParam Long id) {
        return facade.findOneVegetable(id);
    }

    @GetMapping("/list")
    public List<VegetableDto> findAllVegetable() {
        return facade.findAllVegetable();
    }

    @PostMapping
    public VegetableDto createVegetable(@RequestBody VegetableCreateDto dto) {
        return facade.createVegetable(dto);
    }

    @DeleteMapping
    public void remove(Long id) {
        facade.removeVegetable(id);
    }

    @DeleteMapping("/name")
    public void removeVegetableByName(@RequestParam String name) {
        facade.deleteVegetableByName(name);
    }
}

