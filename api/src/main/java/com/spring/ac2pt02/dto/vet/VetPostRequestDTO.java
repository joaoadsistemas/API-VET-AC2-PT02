package com.spring.ac2pt02.dto.vet;

import com.spring.ac2pt02.model.SpecieEnum;

public record VetPostRequestDTO(
        String name,
        String cpf,
        String phone,
        SpecieEnum specialization
) {
}
