package com.spring.ac2pt02.dto.address;

import lombok.Builder;

@Builder
public record AddressPostResponseDTO(
        Long id,
        String street,
        String number,
        String city,
        String state,
        Long tutorId
) {
}
