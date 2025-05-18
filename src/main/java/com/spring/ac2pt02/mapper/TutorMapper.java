package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.tutor.TutorPostResponseDTO;
import com.spring.ac2pt02.model.Tutor;

public class TutorMapper {

    public static TutorPostResponseDTO tutorPostResponseDTO(Tutor tutor) {
        return TutorPostResponseDTO.builder()
                .id(tutor.getId())
                .name(tutor.getName())
                .cpf(tutor.getCpf())
                .phone(tutor.getPhone())
                .build();
    }

}
