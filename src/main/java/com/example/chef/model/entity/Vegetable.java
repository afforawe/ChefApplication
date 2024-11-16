package com.example.chef.model.entity;

import com.example.chef.model.entity.parent.NameEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Vegetable extends NameEntity {

    @Column(name = "calories_one_hundred", nullable = false)
    private BigDecimal caloriesOneHundred;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vegetable vegetable = (Vegetable) obj;
        if (getName().equals(vegetable.getName())) {
            return false;
        }
        return caloriesOneHundred.equals(vegetable.caloriesOneHundred);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + caloriesOneHundred.hashCode();
        return result;
    }
}
