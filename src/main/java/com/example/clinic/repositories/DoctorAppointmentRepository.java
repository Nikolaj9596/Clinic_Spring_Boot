package com.example.clinic.repositories;

import com.example.clinic.models.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long> {}
