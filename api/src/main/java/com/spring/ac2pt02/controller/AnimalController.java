package com.spring.ac2pt02.controller;

import com.spring.ac2pt02.dto.animal.AnimalPostRequestDTO;
import com.spring.ac2pt02.dto.animal.AnimalResponseDTO;
import com.spring.ac2pt02.service.abstraction.AnimalService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{tutorId}")
    public ResponseEntity<Set<AnimalResponseDTO>> findAllByTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(animalService.findAllByTutorId(tutorId));
    }

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> post(@RequestBody AnimalPostRequestDTO requestDTO) {
        return ResponseEntity.ok(animalService.post(requestDTO));
    }

}
