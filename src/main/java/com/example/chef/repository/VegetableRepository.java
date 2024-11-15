package com.example.chef.repository;

import com.example.chef.model.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    Optional<Vegetable> findByName(String name);
}
