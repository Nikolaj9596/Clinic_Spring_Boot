package com.example.clinic.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
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

  public Date getDateStartWork() {
    return dateStartWork;
  }

  public void setDateStartWork(Date dateStartWork) {
    this.dateStartWork = dateStartWork;
  }

  public Profession getProfession() {
    return profession;
  }

  public void setProfession(Profession profession) {
    this.profession = profession;
  }
}
