package com.example.clinic.dto.diagnosis;

import com.example.clinic.dto.client.SmalClientDto;
import com.example.clinic.dto.disease.SmalDiseaseDto;
import com.example.clinic.dto.doctor.SmalDoctorDto;
import java.util.List;
import lombok.Data;

@Data
public class ListDiagnosisDto {
  private String name;
  private SmalClientDto client;
  private SmalDoctorDto doctor;
  private List<SmalDiseaseDto> diseases;
}
