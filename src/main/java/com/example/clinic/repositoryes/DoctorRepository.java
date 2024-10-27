package com.example.clinic.repositoryes;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public interface DoctorRepository
    extends PagingAndSortingRepository<Doctor, Long>, CrudRepository<Doctor, Long> {
  Optional<Doctor> findByFirstName(String firstName);
}
