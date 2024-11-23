package com.example.clinic.repositories;

import com.example.clinic.models.Diagnosis;
import com.example.clinic.models.DiagnosisDisease;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisDiseaseRepository extends JpaRepository<DiagnosisDisease, Long> {
  List<DiagnosisDisease> findByIdIn(List<Long> ids);

  List<DiagnosisDisease> findByDiagnosis(Diagnosis diagnosis);
}
