package com.example.clinic.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "diagnosis_disease")
public class DiagnosisDisease {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "diagnosis_id")
  private Diagnosis diagnosis;

  @ManyToOne
  @JoinColumn(name = "disease_id")
  private Disease disease;
}
