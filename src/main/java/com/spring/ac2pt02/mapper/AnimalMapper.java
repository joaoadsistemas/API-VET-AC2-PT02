package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.animal.AnimalRelatoryResponseDTO;
import com.spring.ac2pt02.dto.animal.AnimalResponseDTO;
import com.spring.ac2pt02.model.Animal;

import java.util.stream.Collectors;

public class AnimalMapper {

    public static AnimalResponseDTO animalPostResponseDTO(Animal animal) {
        return AnimalResponseDTO.builder()
                .id(animal.getId())
                .name(animal.getName())
                .race(animal.getRace())
                .birthDate(animal.getBirthDate())
                .specie(animal.getSpecie())
                .tutorId(animal.getTutor().getId())
                .vaccines(animal.getVaccines().stream().map(VaccineMapper::vaccinePostResponseDTO).collect(Collectors.toSet()))
                .build();
    }

    public static AnimalRelatoryResponseDTO animalRelatoryResponseDTO(Animal animal) {
        return AnimalRelatoryResponseDTO.builder()
                .id( animal.getId())
                .name(animal.getName())
                .specie( animal.getSpecie())
                .race( animal.getRace())
                .birthDate( animal.getBirthDate())
                .tutor(TutorMapper.tutorPostResponseDTO(animal.getTutor()))
                .appointments(animal.getAppointments().stream().map(AppointmentMapper::appointmentRelatoryResponseDTO).collect(Collectors.toSet()))
                .vaccines(animal.getVaccines().stream().map(VaccineMapper::vaccinePostResponseDTO).collect(Collectors.toSet()))
                .build();
    }

}
