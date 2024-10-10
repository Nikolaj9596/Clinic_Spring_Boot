package com.example.clinic.models;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 255)
  private String name;

  @OneToMany(mappedBy = "diagnosis")
  private Set<DiagnosisDisease> diagnosisDiseases;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDiscription() {
    return discription;
  }

  public void setDiscription(String discription) {
    this.discription = discription;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Column(name = "discription", length = 10000)
  private String discription;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "dockor_id")
  private Doctor doctor;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  public Diagnosis() {
    // Конструктор
  }

  public Set<DiagnosisDisease> getDiagnosisDiseases() {
    return diagnosisDiseases;
  }

  public void setDiagnosisDiseases(Set<DiagnosisDisease> diagnosisDiseases) {
    this.diagnosisDiseases = diagnosisDiseases;
  }
}
