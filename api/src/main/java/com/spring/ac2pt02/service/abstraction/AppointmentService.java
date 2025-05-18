package com.spring.ac2pt02.service.abstraction;

import com.spring.ac2pt02.dto.appointment.AppointmentPostRequestDTO;
import com.spring.ac2pt02.dto.appointment.AppointmentPostResponseDTO;


public interface AppointmentService {

    AppointmentPostResponseDTO post(AppointmentPostRequestDTO requestDTO);

}
