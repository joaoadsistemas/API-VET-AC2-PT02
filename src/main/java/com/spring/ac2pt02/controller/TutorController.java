package com.spring.ac2pt02.controller;

import com.spring.ac2pt02.dto.tutor.TutorPostRequestDTO;
import com.spring.ac2pt02.dto.tutor.TutorPostResponseDTO;
import com.spring.ac2pt02.service.abstraction.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutor")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;


    @PostMapping
    public ResponseEntity<TutorPostResponseDTO> post(@RequestBody TutorPostRequestDTO requestDTO) {
        return ResponseEntity.ok(tutorService.post(requestDTO));
    }

}
