package com.example.clinic.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(
    name = "clients",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "uq_client_full_name",
          columnNames = {"first_name", "last_name", "middle_name"})
    })
public class Client {

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

  @Column(name = "address", length = 255)
  private String address;

  @OneToMany(mappedBy = "client")
  private List<DoctorAppointment> appointments;

  @OneToMany(mappedBy = "client")
  private List<Diagnosis> diagnosis;

  public Client() {
    // Конструктор
  }
}
