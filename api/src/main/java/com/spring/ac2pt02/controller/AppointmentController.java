package com.spring.ac2pt02.controller;


import com.spring.ac2pt02.dto.appointment.AppointmentPostRequestDTO;
import com.spring.ac2pt02.dto.appointment.AppointmentPostResponseDTO;
import com.spring.ac2pt02.service.abstraction.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<AppointmentPostResponseDTO> post(@RequestBody AppointmentPostRequestDTO requestDTO) {
        return ResponseEntity.ok(appointmentService.post(requestDTO));
    }

}
