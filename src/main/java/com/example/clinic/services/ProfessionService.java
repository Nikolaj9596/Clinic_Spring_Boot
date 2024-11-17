package com.example.clinic.services;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.clinic.models.Profession;
import com.example.clinic.repositories.ProfessionRepository;

@Service
@RequiredArgsConstructor
public class ProfessionService {
  private final ProfessionRepository repository;

  public Profession getById(Long profession_id) {
    Optional<Profession> profession = repository.findById(profession_id);
    if (profession.isPresent()) {
      throw new RuntimeException("Врача не существует");
    }
    return profession.get();
  }

  public List<Profession> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Profession> page = repository.findAll(pageRequest);
    return page.getContent();
  }
}
