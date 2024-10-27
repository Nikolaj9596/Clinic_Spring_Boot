package com.example.clinic.models;

import jakarta.persistence.*;
import java.util.List;
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

  @Column(name = "name", length = 100, unique = true)
  private String name;

  @Column(name = "description", nullable = true)
  private String description;

  @OneToMany(mappedBy = "disease")
  private List<DiagnosisDisease> diagnosisDiseases;
}
