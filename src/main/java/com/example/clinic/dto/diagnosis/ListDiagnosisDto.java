package com.example.clinic.dto.diagnosis;

import ch.qos.logback.core.net.server.Client;

import com.example.clinic.dto.client.SmalClientDto;
import com.example.clinic.dto.doctor.SmalDoctorDto;
import com.example.clinic.models.DiagnosisDisease;
import com.example.clinic.models.Doctor;
import java.util.List;
import lombok.Data;

@Data
public class ListDiagnosisDto {
  private String name;
  private SmalClientDto client;
  private SmalDoctorDto doctor;
  private List<SmalDiseaseDto> diseases;
}
