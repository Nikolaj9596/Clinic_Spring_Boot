package com.example.clinic.repositories;

import com.example.clinic.models.Diagnosis;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
  Optional<Diagnosis> findByName(String name);

  boolean existsByName(String name);
}
