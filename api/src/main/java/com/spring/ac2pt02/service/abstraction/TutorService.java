package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.tutor.TutorPostRequestDTO;
import com.spring.ac2pt02.dto.tutor.TutorPostResponseDTO;
import com.spring.ac2pt02.model.Tutor;


public interface TutorService {

    TutorPostResponseDTO post(TutorPostRequestDTO requestDTO);
    Tutor findById(Long id);

}
