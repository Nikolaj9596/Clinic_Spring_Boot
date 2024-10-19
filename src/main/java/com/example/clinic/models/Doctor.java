package com.example.clinic.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(
    name = "doctors",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "uq_doctor_full_name",
          columnNames = {"first_name", "last_name", "middle_name"})
    })
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name", length = 50)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(name = "middle_name", length = 50)
  private String middleName;

  @Column(name = "avatar", length = 255)
  private String avatar;

  @Column(name = "date_birthday")
  private Date dateBirthday;

  @Column(name = "date_start_work")
  private Date dateStartWork;

  @ManyToOne
  @JoinColumn(name = "profession_id")
  private Profession profession;

  @OneToMany(mappedBy = "doctor")
  private List<DoctorAppointment> appointments;

  @OneToMany(mappedBy = "doctor")
  private List<Diagnosis> diagnosis;

  public Doctor() {
    // Конструктор
  }
}
