package com.spring.ac2pt02.service;

import com.spring.ac2pt02.dto.appointment.AppointmentPostRequestDTO;
import com.spring.ac2pt02.dto.appointment.AppointmentPostResponseDTO;
import com.spring.ac2pt02.exception.CustomException;
import com.spring.ac2pt02.mapper.AppointmentMapper;
import com.spring.ac2pt02.model.Appointment;
import com.spring.ac2pt02.repository.AppointmentRepository;
import com.spring.ac2pt02.service.abstraction.AnimalService;
import com.spring.ac2pt02.service.abstraction.AppointmentService;
import com.spring.ac2pt02.service.abstraction.VaccineService;
import com.spring.ac2pt02.service.abstraction.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final VaccineService vaccineService;
    private final AnimalService animalService;
    private final VetService vetService;

    @Override
    public AppointmentPostResponseDTO post(AppointmentPostRequestDTO requestDTO) {
        if (requestDTO.executionDate() == null || requestDTO.vetId() == null || requestDTO.animalId() == null) {
            throw new CustomException("Missing required fields", 400);
        }

        var appointment = new Appointment();
        appointment.setExecutionDate(requestDTO.executionDate());

        var vet = vetService.findById(requestDTO.vetId());
        var animal = animalService.findById(requestDTO.animalId());

        LocalDateTime newStart = requestDTO.executionDate();
        LocalDateTime newEnd = newStart.plusHours(1);

        boolean hasConflict = vet.getAppointments().stream().anyMatch(existing -> {
            LocalDateTime existingStart = existing.getExecutionDate();
            LocalDateTime existingEnd = existingStart.plusHours(1);
            return !(newEnd.isBefore(existingStart) || newStart.isAfter(existingEnd));
        });

        if (hasConflict) {
            throw new CustomException(
                    "There is already an appointment scheduled for this date and time for this vet",
                    400
            );
        }

        if (!animal.getSpecie().equals(vet.getSpecialization())) {
            throw new CustomException(
                    "The vet does not have the specialization for this animal",
                    400
            );
        }

        appointment.setVet(vet);
        appointment.setAnimal(animal);

        for (Long vaccineId : requestDTO.vaccinesIds()) {
            var vaccine = vaccineService.findById(vaccineId);
            animal.getVaccines().add(vaccine);
        }

        appointmentRepository.save(appointment);

        return AppointmentMapper.appointmentPostResponseDTO(appointment);
    }
}
