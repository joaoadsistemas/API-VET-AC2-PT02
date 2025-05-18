package com.spring.ac2pt02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vet")
@Getter
@Setter
@NoArgsConstructor
public class Vet extends Person {

    private SpecieEnum specialization;

    @OneToMany(mappedBy = "vet")
    Set<Appointment> appointments = new HashSet<>();

}
