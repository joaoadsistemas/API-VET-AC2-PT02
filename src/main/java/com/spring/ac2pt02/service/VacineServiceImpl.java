package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.vaccine.VaccinePostRequestDTO;
import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.mapper.VaccineMapper;
import com.spring.ac2pt02.model.Vaccine;
import com.spring.ac2pt02.repository.VaccineRepository;
import com.spring.ac2pt02.service.abstraction.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    @Override
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).orElseThrow(() -> new CustomException("This vaccine doesnt exists", 404));
    }

    @Override
    public VaccinePostResponseDTO post(VaccinePostRequestDTO requestDTO) {
        var vaccine = new Vaccine();
        vaccine.setName(requestDTO.name());
        vaccineRepository.save(vaccine);
        return VaccineMapper.vaccinePostResponseDTO(vaccine);
    }
}
