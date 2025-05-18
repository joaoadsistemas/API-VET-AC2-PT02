package com.spring.ac2pt02.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tutor")
@Getter
@Setter
@NoArgsConstructor
public class Tutor extends Person {

    @OneToMany(mappedBy = "tutor")
    private Set<Animal> pets = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
