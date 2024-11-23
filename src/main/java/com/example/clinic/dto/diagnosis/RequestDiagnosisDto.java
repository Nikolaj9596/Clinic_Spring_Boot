package com.example.clinic.dto.diagnosis;

import java.util.List;
import lombok.Data;

@Data
public class RequestDiagnosisDto {
  private String name;
  private Long clientId;
  private Long doctorId;
  private List<Long> diagnosisDiseases;
}
