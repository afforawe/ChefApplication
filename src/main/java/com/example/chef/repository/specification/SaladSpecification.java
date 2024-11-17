package com.example.chef.repository.specification;

import com.example.chef.model.entity.Salad;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

@UtilityClass
public class SaladSpecification {

    public static Specification<Salad> findByCaloriesRange(BigDecimal minCalories, BigDecimal maxCalories) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("calories"), minCalories, maxCalories));
    }
}
