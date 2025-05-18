package com.spring.ac2pt02.repository;

import com.spring.ac2pt02.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Set<Animal> findAllByTutorId(Long tutorId);

}
