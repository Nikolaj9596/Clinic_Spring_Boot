package com.example.clinic.dto.diagnosis;

import java.util.List;
import lombok.Data;

@Data
public class RequestDiagnosisDto {
  private String name;
  private Long client_id;
  private Long doctor_id;
  private List<Long> diagnosisDiseases;
}
