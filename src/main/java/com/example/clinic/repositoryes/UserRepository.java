package com.example.clinic.repositoryes;

import com.example.clinic.models.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
    extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);
}
