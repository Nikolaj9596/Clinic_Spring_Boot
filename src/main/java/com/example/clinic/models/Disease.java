package com.example.clinic.models;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "diseases")
public class Disease {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToMany(mappedBy = "disease")
  private Set<DiagnosisDisease> diagnosisDiseases;

  public Set<DiagnosisDisease> getDiagnosisDiseases() {
    return diagnosisDiseases;
  }
}
