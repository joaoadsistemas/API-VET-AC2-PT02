package com.spring.ac2pt02.controller;

import com.spring.ac2pt02.dto.address.AddressPostRequestDTO;
import com.spring.ac2pt02.dto.address.AddressPostResponseDTO;
import com.spring.ac2pt02.dto.vaccine.VaccinePostRequestDTO;
import com.spring.ac2pt02.dto.vaccine.VaccinePostResponseDTO;
import com.spring.ac2pt02.service.abstraction.AddressService;
import com.spring.ac2pt02.service.abstraction.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @PostMapping
    public ResponseEntity<VaccinePostResponseDTO> post(@RequestBody VaccinePostRequestDTO requestDTO) {
        return ResponseEntity.ok(vaccineService.post(requestDTO));
    }

}
