package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.vet.VetPostRequestDTO;
import com.spring.ac2pt02.dto.vet.VetPostResponseDTO;
import com.spring.ac2pt02.model.Vet;


public interface VetService {


    Vet findById(Long id);
    VetPostResponseDTO post(VetPostRequestDTO requestDTO);

}
