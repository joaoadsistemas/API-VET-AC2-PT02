package com.spring.ac2pt02.controller;

import com.spring.ac2pt02.dto.address.AddressPostRequestDTO;
import com.spring.ac2pt02.dto.address.AddressPostResponseDTO;
import com.spring.ac2pt02.service.abstraction.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressPostResponseDTO> post(@RequestBody AddressPostRequestDTO requestDTO) {
        return ResponseEntity.ok(addressService.post(requestDTO));
    }

}
