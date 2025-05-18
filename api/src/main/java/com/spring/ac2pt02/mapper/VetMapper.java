package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.vet.VetPostResponseDTO;
import com.spring.ac2pt02.model.Vet;

public class VetMapper {

    public static VetPostResponseDTO vetPostResponseDTO(Vet vet) {
        return VetPostResponseDTO.builder()
                .id(vet.getId())
                .name(vet.getName())
                .cpf(vet.getCpf())
                .phone(vet.getPhone())
                .specialization(vet.getSpecialization())
                .build();
    }

}
