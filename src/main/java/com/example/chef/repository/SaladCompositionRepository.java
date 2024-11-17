package com.example.chef.repository;

import com.example.chef.model.entity.SaladComposition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaladCompositionRepository extends JpaRepository<SaladComposition, Long> {
    List<SaladComposition> findAllBySaladId(Long saladId);

    Page<SaladComposition> findAllBySaladId(Long saladId, Pageable pageable);

    Optional<SaladComposition> findBySaladIdAndVegetableId(Long saladId, Long vegetableId);
}
