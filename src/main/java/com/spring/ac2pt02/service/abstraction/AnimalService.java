package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.animal.AnimalPostRequestDTO;
import com.spring.ac2pt02.dto.animal.AnimalRelatoryResponseDTO;
import com.spring.ac2pt02.dto.animal.AnimalResponseDTO;
import com.spring.ac2pt02.model.Animal;

import java.util.Set;


public interface AnimalService {


    AnimalRelatoryResponseDTO getRelatory(Long animalId);
    Animal findById(Long id);
    Set<AnimalResponseDTO> findAllByTutorId(Long tutorId);
    AnimalResponseDTO post(AnimalPostRequestDTO requestDTO);


}
