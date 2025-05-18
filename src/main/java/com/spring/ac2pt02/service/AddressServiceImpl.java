package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.address.AddressPostRequestDTO;
import com.spring.ac2pt02.dto.address.AddressPostResponseDTO;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.mapper.AddressMapper;
import com.spring.ac2pt02.model.Address;
import com.spring.ac2pt02.repository.AddressRepository;
import com.spring.ac2pt02.repository.TutorRepository;
import com.spring.ac2pt02.service.abstraction.AddressService;
import com.spring.ac2pt02.service.abstraction.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final TutorService tutorService;


    @Override
    public AddressPostResponseDTO post(AddressPostRequestDTO requestDTO) {

        var address = new Address();
        address.setCity(requestDTO.city());
        address.setStreet(requestDTO.street());
        address.setNumber(requestDTO.number());
        address.setState(requestDTO.state());
        address.setTutor(tutorService.findById(requestDTO.tutorId()));

        addressRepository.save(address);

        return AddressMapper.addressPostResponseDTO(address);

    }
}
