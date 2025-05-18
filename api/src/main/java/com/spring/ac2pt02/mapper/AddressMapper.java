package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.address.AddressPostResponseDTO;
import com.spring.ac2pt02.model.Address;

public class AddressMapper {

    public static AddressPostResponseDTO addressPostResponseDTO(Address address) {
        return AddressPostResponseDTO.builder()
                .id(address.getId())
                .city(address.getCity())
                .state(address.getState())
                .number(address.getNumber())
                .street(address.getStreet())
                .tutorId(address.getTutor().getId())
                .build();
    }

}
