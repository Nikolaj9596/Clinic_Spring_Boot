package com.example.clinic.dto.doctor_appointment;

import java.sql.Date;
import lombok.Data;

@Data
public class CreateDoctorAppointmentsDto {
  private Long client_id;
  private Long doctor_id;
  private Date startDateAppointment;
  private Date endDateAppointment;
}
