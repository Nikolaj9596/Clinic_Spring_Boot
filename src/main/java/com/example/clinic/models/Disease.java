package com.example.clinic.models;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "disease")
public class Disease {

  @OneToMany(mappedBy = "disease")
  private Set<DiagnosisDisease> diagnosisDiseases;

  public Set<DiagnosisDisease> getDiagnosisDiseases() {
    return diagnosisDiseases;
  }

  public void setDiagnosisDiseases(Set<DiagnosisDisease> diagnosisDiseases) {
    this.diagnosisDiseases = diagnosisDiseases;
  }
}
