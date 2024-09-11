package com.example.clinic.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "clients")
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

  @UniqueConstraint(
      name = "uq_client_full_name",
      columnNames = {"first_name", "last_name", "middle_name"})

  public Client() {
    // Конструктор
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Date getDateBirthday() {
    return dateBirthday;
  }

  public void setDateBirthday(Date dateBirthday) {
    this.dateBirthday = dateBirthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<DoctorAppointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<DoctorAppointment> appointments) {
    this.appointments = appointments;
  }

  public List<Diagnosis> getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(List<Diagnosis> diagnosis) {
    this.diagnosis = diagnosis;
  }
}
