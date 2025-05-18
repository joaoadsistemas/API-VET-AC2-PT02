package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.vet.VetPostRequestDTO;
import com.spring.ac2pt02.dto.vet.VetPostResponseDTO;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.mapper.VetMapper;
import com.spring.ac2pt02.model.Tutor;
import com.spring.ac2pt02.model.Vet;
import com.spring.ac2pt02.repository.VetRepository;
import com.spring.ac2pt02.service.abstraction.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow(() -> new CustomException("This vet doesnt exists", 404));
    }

    @Override
    public VetPostResponseDTO post(VetPostRequestDTO requestDTO) {
        var vet = new Vet();
        vet.setName(requestDTO.name());
        vet.setCpf(requestDTO.cpf());
        vet.setPhone(requestDTO.phone());
        vet.setSpecialization(requestDTO.specialization());
        vetRepository.save(vet);
        return VetMapper.vetPostResponseDTO(vet);
    }
}
