package com.example.clinic.services;

import com.example.clinic.dto.diagnosis.RequestDiagnosisDto;
import com.example.clinic.models.Diagnosis;
import com.example.clinic.repositories.ClientRepository;
import com.example.clinic.repositories.DiagnosisDiseaseRepository;
import com.example.clinic.repositories.DiagnosisRepository;
import com.example.clinic.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosisService {
  private final DiagnosisDiseaseRepository diagnosisDiseaseRepository;
  private final DiagnosisRepository diagnosRepository;
  private final DoctorRepository doctorRepository;
  private final ClientRepository clientRepository;

  public Diagnosis create(RequestDiagnosisDto request) {
    Diagnosis diagnos =
        Diagnosis.builder()
            .name(request.getName())
            .client(clientRepository.getById(request.getClientId()))
            .doctor(doctorRepository.getById(request.getDoctorId()))
            .diagnosisDiseases(diagnosisDiseaseRepository.findByIdIn(request.getDiagnosisDiseases()))
            .build();
    return diagnosRepository.save(diagnos);
  }

  public Diagnosis update(long diagnos_id, RequestDiagnosisDto request) {
    if (!diagnosRepository.existsById(diagnos_id)) {
      throw new RuntimeException("Диагноз не существует");
    }

    Diagnosis diagnos =
        Diagnosis.builder()
            .name(request.getName())
            .client(clientRepository.getById(request.getClientId()))
            .doctor(doctorRepository.getById(request.getDoctorId()))
            .diagnosisDiseases(diagnosisDiseaseRepository.findByIdIn(request.getDiagnosisDiseases()))
            .build();
    return diagnosRepository.save(diagnos);
  }

  public void delete(Long diagnos_id) {
    diagnosRepository.deleteById(diagnos_id);
  }

  public Diagnosis getById(Long diagnos_id) {
    Optional<Diagnosis> optionalDiagnosis = diagnosRepository.findById(diagnos_id);
    Diagnosis diagnos =
        optionalDiagnosis.orElseThrow(() -> new RuntimeException("Диагноз не существует"));

    diagnos.setClient(clientRepository.findById(diagnos.getClient().getId()).orElse(null));
    diagnos.setDoctor(doctorRepository.findById(diagnos.getDoctor().getId()).orElse(null));
    diagnos.setDiagnosisDiseases(diagnosisDiseaseRepository.findByDiagnosis(diagnos));
    return diagnos;
  }

  public List<Diagnosis> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<Diagnosis> page = diagnosRepository.findAll(pageRequest);
    List<Diagnosis> diagnoses = page.getContent();

    for (Diagnosis diagnosis : diagnoses) {
      diagnosis.setClient(clientRepository.findById(diagnosis.getClient().getId()).orElse(null));
      diagnosis.setDoctor(doctorRepository.findById(diagnosis.getDoctor().getId()).orElse(null));
      diagnosis.setDiagnosisDiseases(diagnosisDiseaseRepository.findByDiagnosis(diagnosis));
    }

    return diagnoses;
  }
}
