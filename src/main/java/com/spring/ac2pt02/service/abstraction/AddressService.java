package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.address.AddressPostRequestDTO;
import com.spring.ac2pt02.dto.address.AddressPostResponseDTO;

public interface AddressService {

    AddressPostResponseDTO post(AddressPostRequestDTO requestDTO);
}
