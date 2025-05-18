package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.tutor.TutorPostRequestDTO;
import com.spring.ac2pt02.dto.tutor.TutorPostResponseDTO;
import com.spring.ac2pt02.mapper.TutorMapper;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.model.Tutor;
import com.spring.ac2pt02.repository.TutorRepository;
import com.spring.ac2pt02.service.abstraction.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;


    @Override
    public Tutor findById(Long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new CustomException("This tutor doesnt exists", 404));
    }


    @Override
    public TutorPostResponseDTO post(TutorPostRequestDTO requestDTO) {
        var tutor = new Tutor();
        tutor.setName(requestDTO.name());
        tutor.setCpf(requestDTO.cpf());
        tutor.setPhone(requestDTO.phone());
        tutorRepository.save(tutor);

        return TutorMapper.tutorPostResponseDTO(tutor);
    }


}
