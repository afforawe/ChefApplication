package com.example.chef.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<E> {

    Page<E> findAll(Pageable pageable);

    E findById(Long id);

    E save(E entity);

    void remove(Long id);

}
