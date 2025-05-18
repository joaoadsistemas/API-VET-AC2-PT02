package com.spring.ac2pt02.dto.appointment;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
public record AppointmentPostResponseDTO(
        Long id,
        LocalDateTime executionDate,
        String observation,
        Set<Long> vaccinesIds,
        Long vetId,
        Long animalId
){
}
