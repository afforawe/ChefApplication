package com.example.chef.controller;

import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.PageDto;
import com.example.chef.model.dto.VegetableDto;
import com.example.chef.model.dto.create.VegetableCreateDto;
import com.example.chef.model.dto.update.VegetableUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vegetables")
public class VegetableController implements PageController<VegetableDto>, CommonController<VegetableDto, VegetableCreateDto, VegetableUpdateDto>,
        DeleteByNameController {

    private final ChefFacade facade;

    @Override
    public ResponseEntity<List<VegetableDto>> findAll(PageDto dto) {
        return new ResponseEntity<>(facade.findAllVegetables(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VegetableDto> findById(Long id) {
        return new ResponseEntity<>(facade.findVegetableById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VegetableDto> update(VegetableUpdateDto dto) {
        return new ResponseEntity<>(facade.updateVegetable(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VegetableDto> create(VegetableCreateDto dto) {
        return new ResponseEntity<>(facade.createVegetable(dto), HttpStatus.OK);
    }

    @Override
    public void remove(Long id) {
        facade.removeVegetable(id);
    }

    @Override
    public void remove(String name) {
        facade.deleteVegetableByName(name);
    }
}

