package com.example.clinic.dto.diagnosis;

import ch.qos.logback.core.net.server.Client;
import com.example.clinic.models.DiagnosisDisease;
import com.example.clinic.models.Doctor;
import java.util.List;
import lombok.Data;

@Data
public class DiagnosisDetailsDto {
  private String name;
  private Client client;
  private Doctor doctor;
  private List<DiagnosisDisease> diagnosisDiseases;
}
