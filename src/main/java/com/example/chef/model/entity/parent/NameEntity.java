package com.example.chef.model.entity.parent;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity {

    private String name;
}
