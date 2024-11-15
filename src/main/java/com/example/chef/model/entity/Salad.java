package com.example.chef.model.entity;

import com.example.chef.model.entity.parent.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Salad extends NameEntity {

    @Column(precision = 6, scale = 2)
    private BigDecimal weight;

    @Column(precision = 6, scale = 2)
    private BigDecimal calories;

    @OneToMany(mappedBy = "salad", fetch = FetchType.EAGER)
    private List<SaladComposition> composition;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Salad salad = (Salad) obj;
        return getName().equals(salad.getName());
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}


