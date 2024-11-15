package com.example.chef.repository;

import com.example.chef.model.entity.Salad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaladRepository extends JpaRepository<Salad, Long> {
}
