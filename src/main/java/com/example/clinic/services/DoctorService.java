package com.example.clinic.services;

import com.example.clinic.models.Doctor;
import com.example.clinic.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
  private final DoctorRepository repository;

  public Doctor create(Doctor doctor) {
    return repository.save(doctor);
  }

  public Doctor update(long doctor_id, Doctor doctor) {
    if (!repository.existsById(doctor_id)) {
      throw new RuntimeException("Врача не существует");
    }
    return repository.save(doctor);
  }

  public void delete(Long doctor_id) {
    repository.deleteById(doctor_id);
  }

  public Doctor getById(Long doctor_id) {
    Optional<Doctor> doctor = repository.findById(doctor_id);
    if (doctor.isPresent()) {
      throw new RuntimeException("Врача не существует");
    }
    return doctor.get();
  }

  public List<Doctor> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Doctor> page = repository.findAll(pageRequest);
    return page.getContent();
  }
}
