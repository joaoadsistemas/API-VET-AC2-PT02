package com.spring.ac2pt02.dto.animal;

import com.spring.ac2pt02.dto.appointment.AppointmentRelatoryResponseDTO;
import com.spring.ac2pt02.dto.tutor.TutorPostResponseDTO;
import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.model.SpecieEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record AnimalRelatoryResponseDTO(
        Long id,
        String name,
        SpecieEnum specie,
        String race,
        LocalDate birthDate,
        TutorPostResponseDTO tutor,
        Set<AppointmentRelatoryResponseDTO> appointments,
        Set<VaccinePostResponseDTO> vaccines
) {
}
