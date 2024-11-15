package com.example.chef.model.entity;

import com.example.chef.model.entity.parent.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "salad_composition")
public class SaladComposition extends BaseEntity {

    @Column(name = "salad_id", insertable = false, updatable = false)
    private Long saladId;

    @Column(name = "vegetable_id", insertable = false, updatable = false)
    private Long vegetableId;

    @ManyToOne
    @JoinColumn(name = "salad_id", nullable = false)
    private Salad salad;

    @ManyToOne
    @JoinColumn(name = "vegetable_id", nullable = false)
    private Vegetable vegetable;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal weight;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal calories;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SaladComposition that = (SaladComposition) obj;
        if (!salad.equals(that.salad)) {
            return false;
        }
        return vegetable.equals(that.vegetable);
    }

    @Override
    public int hashCode() {
        int result = salad.hashCode();
        result = 31 * result + vegetable.hashCode();
        return result;
    }
}
