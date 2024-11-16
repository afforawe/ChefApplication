package com.example.chef.controller;

import com.example.chef.model.dto.PageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface PageController<D> {

    @GetMapping("/all")
    ResponseEntity<List<D>> findAll(PageDto dto);
}
