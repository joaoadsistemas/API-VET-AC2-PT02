package com.spring.ac2pt02.dto.vaccine;

import lombok.Builder;

@Builder
public record VaccinePostResponseDTO(
        Long id,
        String name
){
}
