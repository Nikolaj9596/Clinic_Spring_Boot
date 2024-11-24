package com.example.clinic.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "doctor_appointments")
public class DoctorAppointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @Column(name = "start_date_appointment")
  private Date startDateAppointment;

  @Column(name = "end_date_appointment")
  private Date endDateAppointment;
}
