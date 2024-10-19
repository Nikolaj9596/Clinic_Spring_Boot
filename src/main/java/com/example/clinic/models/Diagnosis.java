package com.example.clinic.models;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "diagnosis")
public class Diagnosis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 255)
  private String name;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @OneToMany(mappedBy = "diagnosis")
  private Set<DiagnosisDisease> diagnosisDiseases;
}
