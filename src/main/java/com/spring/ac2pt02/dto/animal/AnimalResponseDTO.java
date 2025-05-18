package com.spring.ac2pt02.dto.animal;

import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.model.SpecieEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record AnimalResponseDTO(
        Long id,
        String name,
        SpecieEnum specie,
        String race,
        LocalDate birthDate,
        Long tutorId,
        Set<VaccinePostResponseDTO> vaccines
) {
}
