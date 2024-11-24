package com.example.clinic.dto.doctor_appointment;

import java.sql.Date;
import lombok.Data;

@Data
public class RequestDoctorAppointmentDto {
  private Long clientId;
  private Long doctorId;
  private Date startDateAppointment;
  private Date endDateAppointment;
}
