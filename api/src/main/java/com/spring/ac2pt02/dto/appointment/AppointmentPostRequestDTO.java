package com.spring.ac2pt02.dto.appointment;

import java.time.LocalDateTime;
import java.util.List;

public record AppointmentPostRequestDTO(
        LocalDateTime executionDate,
        String observation,
        List<Long> vaccinesIds,
        Long vetId,
        Long animalId
){
}
