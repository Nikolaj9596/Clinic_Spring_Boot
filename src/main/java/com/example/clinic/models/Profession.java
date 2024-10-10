package com.example.clinic.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "professions")
public class Profession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 100, unique = true)
  private String name;

  @OneToMany(mappedBy = "profession")
  private List<Doctor> doctors;

  public Profession() {
    // Конструктор
  }

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

  public List<Doctor> getDoctors() {
    return doctors;
  }

  public void setDoctors(List<Doctor> doctors) {
    this.doctors = doctors;
  }
}
