package com.example.clinic.services;

import com.example.clinic.repositoryes.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
  private final DocktorRepository repository;

  public Doctor save(Doctor doctor) {
    return repository.save(doctor);
  }

  public Doctor create(Doctor doctor) {
    if (repository.existsByFirstName(doctor.getFirstName())) {
      throw new RuntimeException("Пользователь с  email уже существует");
    }
    return save(doctor);
  }

  public User getByUsername(String email) {
    return repository
        .findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
  }

  public UserDetailsService userDetailsService() {
    return this::getByUsername;
  }
}
