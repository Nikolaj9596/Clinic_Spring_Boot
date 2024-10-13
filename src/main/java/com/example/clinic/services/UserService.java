package com.example.clinic.services;

import com.example.clinic.models.User;
import com.example.clinic.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User save(User user) {
    return repository.save(user);
  }

  public User create(User user) {
    if (repository.existsByEmail(user.getEmail())) {
      throw new RuntimeException("Пользователь с таким email уже существует");
    }
    return save(user);
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
