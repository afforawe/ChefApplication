package com.example.chef.controller;

import com.example.chef.facade.ChefFacade;
import com.example.chef.model.dto.PageDto;
import com.example.chef.model.dto.SaladDto;
import com.example.chef.model.dto.create.SaladCreateDto;
import com.example.chef.model.dto.update.SaladUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/salads")
public class SaladController implements PageController<SaladDto>, CommonController<SaladDto, SaladCreateDto, SaladUpdateDto>,
        DeleteByNameController {

    private final ChefFacade facade;

    @Override
    public ResponseEntity<List<SaladDto>> findAll(PageDto dto) {
        return new ResponseEntity<>(facade.findAllSalads(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaladDto> findById(Long id) {
        return new ResponseEntity<>(facade.findSaladById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaladDto> create(SaladCreateDto dto) {
        return new ResponseEntity<>(facade.createSalad(dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SaladDto> update(SaladUpdateDto dto) {
        return new ResponseEntity<>(facade.updateSalad(dto), HttpStatus.OK);
    }

    @Override
    public void remove(Long id) {
        facade.removeSalad(id);
    }

    @Override
    public void remove(String name) {
        facade.deleteSaladByName(name);
    }
}