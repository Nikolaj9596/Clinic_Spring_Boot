package com.example.clinic.repositories;

import com.example.clinic.models.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  Optional<Client> findByFirstName(String firstName);

  boolean existsByFirstName(String firstName);
}
