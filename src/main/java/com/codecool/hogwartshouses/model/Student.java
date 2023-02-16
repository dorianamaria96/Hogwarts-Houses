package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private PetType petType;

    public Student(String name, PetType petType) {
        this.name = name;
        this.petType = petType;
    }

}
