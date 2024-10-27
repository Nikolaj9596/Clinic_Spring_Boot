package com.example.clinic.dto.doctor_appointment;

import java.sql.Date;
import lombok.Data;

@Data
public class DoctorAppointmentsDetailsDto {
  private Long id;
  private Long client_id;
  private Long doctor_id;
  private Date startDateAppointment;
  private Date endDateAppointment;
}
