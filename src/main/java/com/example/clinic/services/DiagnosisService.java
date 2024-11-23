package com.example.clinic.services;

import com.example.clinic.models.Diagnosis;
import com.example.clinic.repositories.DiagnosisRepository;
import com.example.clinic.repositories.DiseaseRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosisService {
  private final DiagnosisRepository disagnos_repository;
  private final DiseaseRepository disease_repository;

  public Diagnosis create(Diagnosis diagnos) {
    return repository.save(diagnos);
  }

  public Diagnosis update(long diagnos_id, Diagnosis diagnos) {
    if (!repository.existsById(diagnos_id)) {
      throw new RuntimeException("Диагноз не существует");
    }
    return repository.save(diagnos);
  }

  public void delete(Long diagnos_id) {
    repository.deleteById(diagnos_id);
  }

  public Diagnosis getById(Long diagnos_id) {
    Optional<Diagnosis> diagnosis = repository.findById(diagnos_id);
    if (diagnosis.isPresent()) {
      throw new RuntimeException("Диагноз не существует");
    }
    return diagnosis.get();
  }

  public List<Diagnosis> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Diagnosis> page = repository.findAll(pageRequest);
    return page.getContent();
  }
}
