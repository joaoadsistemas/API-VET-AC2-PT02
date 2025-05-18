package com.spring.ac2pt02.dto.address;

public record AddressPostRequestDTO(
        String street,
        String number,
        String city,
        String state,
        Long tutorId
) {
}
