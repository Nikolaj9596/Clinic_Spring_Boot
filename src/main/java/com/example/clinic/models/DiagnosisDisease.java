package com.example.clinic.models;

import javax.persistence.*;

@Entity
@Table(name = "diagnosis_disease")
public class DiagnosisDisease {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "diagnosis_id")
  private Diagnosis diagnosis;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Diagnosis getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(Diagnosis diagnosis) {
    this.diagnosis = diagnosis;
  }

  public Disease getDisease() {
    return disease;
  }

  public void setDisease(Disease disease) {
    this.disease = disease;
  }

  @ManyToOne
  @JoinColumn(name = "disease_id")
  private Disease disease;
}
