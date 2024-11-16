package com.example.chef.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CommonController<D, DC, DU> {

    @GetMapping("/one")
    ResponseEntity<D> findById(@RequestParam("id") Long id);

    @PostMapping("/create")
    ResponseEntity<D> create(@RequestBody DC dto);

    @PostMapping("/update")
    ResponseEntity<D> update(@RequestBody DU dto);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id);

}
