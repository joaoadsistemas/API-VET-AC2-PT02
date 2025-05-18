package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.vaccine.VaccinePostRequestDTO;
import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.model.Vaccine;


public interface VaccineService {

    Vaccine findById(Long id);
    VaccinePostResponseDTO post(VaccinePostRequestDTO requestDTO);

}
