package com.example.clinic.repositories;

import com.example.clinic.models.Doctor;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  Optional<Doctor> findByFirstName(String firstName);

  boolean existsByFirstName(String firstName);
}
