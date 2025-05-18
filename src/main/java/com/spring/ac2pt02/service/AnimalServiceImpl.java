package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.animal.AnimalPostRequestDTO;
import com.spring.ac2pt02.dto.animal.AnimalRelatoryResponseDTO;
import com.spring.ac2pt02.dto.animal.AnimalResponseDTO;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.mapper.AnimalMapper;
import com.spring.ac2pt02.model.Animal;
import com.spring.ac2pt02.repository.AnimalRepository;
import com.spring.ac2pt02.service.abstraction.AnimalService;
import com.spring.ac2pt02.service.abstraction.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final TutorService tutorService;
    private final AnimalRepository animalRepository;

    @Override
    public AnimalRelatoryResponseDTO getRelatory(Long animalId) {
        var animal = findById(animalId);
        return AnimalMapper.animalRelatoryResponseDTO(animal);
    }

    @Override
    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new CustomException("This animal doesnt exists", 404));
    }

    @Override
    public Set<AnimalResponseDTO> findAllByTutorId(Long tutorId) {
        return animalRepository.findAllByTutorId(tutorId).stream().map(AnimalMapper::animalPostResponseDTO).collect(Collectors.toSet());
    }

    @Override
    public AnimalResponseDTO post(AnimalPostRequestDTO requestDTO) {
        var animal = new Animal();
        animal.setName(requestDTO.name());
        animal.setRace(requestDTO.race());
        animal.setSpecie(requestDTO.specie());
        animal.setBirthDate(requestDTO.birthDate());
        animal.setTutor(tutorService.findById(requestDTO.tutorId()));
        animalRepository.save(animal);

        return AnimalMapper.animalPostResponseDTO(animal);
    }
}
