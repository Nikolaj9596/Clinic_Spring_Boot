package com.example.clinic.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "professions")
// @Builder
public class Profession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", length = 100, unique = true)
  private String name;

  @OneToMany(mappedBy = "profession")
  private List<Doctor> doctors;
}
