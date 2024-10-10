package com.example.clinic.models;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "doctor_appointments")
public class DoctorAppointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @Column(name = "start_date_appointment")
  private Date startDateAppointment;

  @Column(name = "end_date_appointment")
  private Date endDateAppointment;

  public DoctorAppointment() {
    // Конструктор
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Date getStartDateAppointment() {
    return startDateAppointment;
  }

  public void setStartDateAppointment(Date startDateAppointment) {
    this.startDateAppointment = startDateAppointment;
  }

  public Date getEndDateAppointment() {
    return endDateAppointment;
  }

  public void setEndDateAppointment(Date endDateAppointment) {
    this.endDateAppointment = endDateAppointment;
  }
}
