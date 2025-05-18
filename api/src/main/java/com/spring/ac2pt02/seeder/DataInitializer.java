package com.spring.ac2pt02.seeder;
import com.spring.ac2pt02.model.*;
import com.spring.ac2pt02.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            AddressRepository addressRepository,
            TutorRepository tutorRepository,
            VetRepository vetRepository,
            AnimalRepository animalRepository,
            VaccineRepository vaccineRepository,
            AppointmentRepository appointmentRepository) {

        return args -> {

            Address address1 = new Address();
            address1.setStreet("Rua das Flores");
            address1.setNumber("123");
            address1.setCity("São Paulo");
            address1.setState("SP");

            Address address2 = new Address();
            address2.setStreet("Avenida Paulista");
            address2.setNumber("1000");
            address2.setCity("São Paulo");
            address2.setState("SP");

            Address address3 = new Address();
            address3.setStreet("Rua dos Animais");
            address3.setNumber("456");
            address3.setCity("Rio de Janeiro");
            address3.setState("RJ");

            addressRepository.saveAll(Arrays.asList(address1, address2, address3));

            Tutor tutor1 = new Tutor();
            tutor1.setName("João Silva");
            tutor1.setCpf("123.456.789-00");
            tutor1.setPhone("(11) 99999-1111");
            tutor1.setAddress(address1);

            Tutor tutor2 = new Tutor();
            tutor2.setName("Maria Oliveira");
            tutor2.setCpf("987.654.321-00");
            tutor2.setPhone("(11) 99999-2222");
            tutor2.setAddress(address2);

            Tutor tutor3 = new Tutor();
            tutor3.setName("Carlos Souza");
            tutor3.setCpf("456.789.123-00");
            tutor3.setPhone("(21) 99999-3333");
            tutor3.setAddress(address3);

            tutorRepository.saveAll(Arrays.asList(tutor1, tutor2, tutor3));

            address1.setTutor(tutor1);
            address2.setTutor(tutor2);
            address3.setTutor(tutor3);
            addressRepository.saveAll(Arrays.asList(address1, address2, address3));

            Vet vet1 = new Vet();
            vet1.setName("Dr. Ricardo");
            vet1.setCpf("111.222.333-44");
            vet1.setPhone("(11) 98888-1111");
            vet1.setSpecialization(SpecieEnum.DOG);

            Vet vet2 = new Vet();
            vet2.setName("Dra. Fernanda");
            vet2.setCpf("222.333.444-55");
            vet2.setPhone("(11) 98888-2222");
            vet2.setSpecialization(SpecieEnum.CAT);

            Vet vet3 = new Vet();
            vet3.setName("Dr. Marcos");
            vet3.setCpf("333.444.555-66");
            vet3.setPhone("(21) 98888-3333");
            vet3.setSpecialization(SpecieEnum.BIRD);

            vetRepository.saveAll(Arrays.asList(vet1, vet2, vet3));

            Vaccine vaccine1 = new Vaccine();
            vaccine1.setName("Antirrábica");

            Vaccine vaccine2 = new Vaccine();
            vaccine2.setName("V8/V10");

            Vaccine vaccine3 = new Vaccine();
            vaccine3.setName("Giárdia");

            Vaccine vaccine4 = new Vaccine();
            vaccine4.setName("Gripe Felina");

            vaccineRepository.saveAll(Arrays.asList(vaccine1, vaccine2, vaccine3, vaccine4));

            Animal animal1 = new Animal();
            animal1.setName("Rex");
            animal1.setSpecie(SpecieEnum.DOG);
            animal1.setRace("Labrador");
            animal1.setBirthDate(LocalDate.of(2020, 5, 15));
            animal1.setTutor(tutor1);
            animal1.getVaccines().add(vaccine1);
            animal1.getVaccines().add(vaccine2);

            Animal animal2 = new Animal();
            animal2.setName("Miau");
            animal2.setSpecie(SpecieEnum.CAT);
            animal2.setRace("Siamês");
            animal2.setBirthDate(LocalDate.of(2021, 3, 10));
            animal2.setTutor(tutor1);
            animal2.getVaccines().add(vaccine1);
            animal2.getVaccines().add(vaccine4);

            Animal animal3 = new Animal();
            animal3.setName("Pingo");
            animal3.setSpecie(SpecieEnum.DOG);
            animal3.setRace("Poodle");
            animal3.setBirthDate(LocalDate.of(2019, 7, 22));
            animal3.setTutor(tutor2);
            animal3.getVaccines().add(vaccine1);
            animal3.getVaccines().add(vaccine3);

            Animal animal4 = new Animal();
            animal4.setName("Piu");
            animal4.setSpecie(SpecieEnum.BIRD);
            animal4.setRace("Canário");
            animal4.setBirthDate(LocalDate.of(2022, 1, 5));
            animal4.setTutor(tutor3);

            animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3, animal4));

            tutor1.getPets().add(animal1);
            tutor1.getPets().add(animal2);
            tutor2.getPets().add(animal3);
            tutor3.getPets().add(animal4);
            tutorRepository.saveAll(Arrays.asList(tutor1, tutor2, tutor3));

            Appointment appointment1 = new Appointment();
            appointment1.setExecutionDate(LocalDateTime.now().minusDays(30));
            appointment1.setObservation("Consulta de rotina. Animal com saúde normal.");
            appointment1.setVet(vet1);
            appointment1.setAnimal(animal1);

            Appointment appointment2 = new Appointment();
            appointment2.setExecutionDate(LocalDateTime.now().minusDays(15));
            appointment2.setObservation("Animal com sintomas de resfriado. Medicação receitada.");
            appointment2.setVet(vet2);
            appointment2.setAnimal(animal2);

            Appointment appointment3 = new Appointment();
            appointment3.setExecutionDate(LocalDateTime.now().minusDays(7));
            appointment3.setObservation("Aplicação de vacina e verificação de rotina.");
            appointment3.setVet(vet1);
            appointment3.setAnimal(animal3);

            Appointment appointment4 = new Appointment();
            appointment4.setExecutionDate(LocalDateTime.now().plusDays(5));
            appointment4.setObservation("Consulta agendada para verificação das asas.");
            appointment4.setVet(vet3);
            appointment4.setAnimal(animal4);

            appointmentRepository.saveAll(Arrays.asList(appointment1, appointment2, appointment3, appointment4));

            animal1.getAppointments().add(appointment1);
            animal2.getAppointments().add(appointment2);
            animal3.getAppointments().add(appointment3);
            animal4.getAppointments().add(appointment4);
            animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3, animal4));

            vet1.getAppointments().add(appointment1);
            vet1.getAppointments().add(appointment3);
            vet2.getAppointments().add(appointment2);
            vet3.getAppointments().add(appointment4);
            vetRepository.saveAll(Arrays.asList(vet1, vet2, vet3));
        };
    }
}
