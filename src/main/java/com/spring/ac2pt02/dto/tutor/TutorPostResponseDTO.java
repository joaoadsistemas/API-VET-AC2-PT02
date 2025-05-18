package com.spring.ac2pt02.dto.tutor;

import lombok.Builder;

@Builder
public record TutorPostResponseDTO(
        Long id,
        String name,
        String cpf,
        String phone
) {
}
