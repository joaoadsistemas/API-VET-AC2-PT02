package com.spring.ac2pt02.controller;


import com.spring.ac2pt02.dto.vet.VetPostRequestDTO;
import com.spring.ac2pt02.dto.vet.VetPostResponseDTO;
import com.spring.ac2pt02.service.abstraction.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vet")
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;


    @PostMapping
    public ResponseEntity<VetPostResponseDTO> post(@RequestBody VetPostRequestDTO requestDTO) {
        return ResponseEntity.ok(vetService.post(requestDTO));
    }

}
