package com.example.clinic.services;

import com.example.clinic.models.Disease;
import com.example.clinic.repositories.DiseaseRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseService {
  private final DiseaseRepository repository;

  public Disease create(Disease disease) {
    return repository.save(disease);
  }

  public Disease update(long disease_id, Disease disease) {
    if (!repository.existsById(disease_id)) {
      throw new RuntimeException("Заболевание не существует");
    }
    return repository.save(disease);
  }

  public void delete(Long disease_id) {
    repository.deleteById(disease_id);
  }

  public Disease getById(Long disease_id) {
    Optional<Disease> disease = repository.findById(disease_id);
    if (disease.isPresent()) {
      throw new RuntimeException("Заболевание не существует");
    }
    return disease.get();
  }

  public List<Disease> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Disease> page = repository.findAll(pageRequest);
    return page.getContent();
  }
}
