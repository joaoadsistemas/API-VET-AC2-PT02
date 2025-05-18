package com.spring.ac2pt02.dto.animal;

import com.spring.ac2pt02.model.SpecieEnum;

import java.time.LocalDate;

public record AnimalPostRequestDTO(
        String name,
        SpecieEnum specie,
        String race,
        LocalDate birthDate,
        Long tutorId
) {
}
