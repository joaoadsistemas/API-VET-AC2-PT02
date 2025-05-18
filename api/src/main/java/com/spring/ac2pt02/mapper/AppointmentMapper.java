package com.spring.ac2pt02.mapper;

import com.spring.ac2pt02.dto.appointment.AppointmentPostResponseDTO;
import com.spring.ac2pt02.dto.appointment.AppointmentRelatoryResponseDTO;
import com.spring.ac2pt02.dto.vet.VetPostResponseDTO;
import com.spring.ac2pt02.model.Appointment;
import com.spring.ac2pt02.model.Vaccine;
import com.spring.ac2pt02.model.Vet;

import java.util.stream.Collectors;

public class AppointmentMapper {

    public static AppointmentPostResponseDTO appointmentPostResponseDTO(Appointment appointment) {
        return AppointmentPostResponseDTO.builder()
                .id(appointment.getId())
                .executionDate(appointment.getExecutionDate())
                .observation(appointment.getObservation())
                .vaccinesIds(appointment.getAnimal().getVaccines().stream().map(Vaccine::getId).collect(Collectors.toSet()))
                .vetId(appointment.getVet().getId())
                .animalId(appointment.getAnimal().getId())
                .build();
    }

    public static AppointmentRelatoryResponseDTO appointmentRelatoryResponseDTO(Appointment appointment) {
        return AppointmentRelatoryResponseDTO.builder()
                .id(appointment.getId())
                .executionDate(appointment.getExecutionDate())
                .observation(appointment.getObservation())
                .build();
    }

}
