package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.model.Vaccine;

public class VaccineMapper {

    public static VaccinePostResponseDTO vaccinePostResponseDTO(Vaccine vaccine) {
        return VaccinePostResponseDTO.builder()
                .id(vaccine.getId())
                .name(vaccine.getName())
                .build();
    }

}
