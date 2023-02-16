package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private HouseType houseType;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();


    public Room(HouseType houseType, Set<Student> students) {
        this.houseType = houseType;
        this.students = students;
    }

}
