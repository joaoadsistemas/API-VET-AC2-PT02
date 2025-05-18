package com.spring.ac2pt02.dto.vet;

import com.spring.ac2pt02.model.SpecieEnum;
import lombok.Builder;

@Builder
public record VetPostResponseDTO(
        Long id,
        String name,
        String cpf,
        String phone,
        SpecieEnum specialization
) {
}
