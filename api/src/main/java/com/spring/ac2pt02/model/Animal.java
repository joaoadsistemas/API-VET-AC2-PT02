package com.spring.ac2pt02.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private SpecieEnum specie;

    private String race;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "animal")
    Set<Appointment> appointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToMany
    @JoinTable(name = "animal_vaccine",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id"))
    private Set<Vaccine> vaccines = new HashSet<>();

}
