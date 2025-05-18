package com.spring.ac2pt02.dto.appointment;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record AppointmentRelatoryResponseDTO(
        Long id,
        LocalDateTime executionDate,
        String observation
){
}
