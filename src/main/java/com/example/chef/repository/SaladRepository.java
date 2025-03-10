package com.example.chef.repository;

import com.example.chef.model.entity.Salad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaladRepository extends JpaRepository<Salad, Long>, JpaSpecificationExecutor<Salad> {

    Optional<Salad> findByName(String name);
}
