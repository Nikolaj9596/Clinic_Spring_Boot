package com.example.clinic.repositories;

import com.example.clinic.models.Doctor;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
  Optional<Doctor> findByFirstName(String firstName);

  boolean existsByFirstName(String firstName);

  Page<Doctor> findAll(PageRequest pageRequest);
}
