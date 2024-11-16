package com.example.chef.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface DeleteByNameController {

    @DeleteMapping("/name")
    void remove(@RequestParam("name") String name);
}
