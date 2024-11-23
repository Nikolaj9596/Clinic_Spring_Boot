package com.example.clinic.controllers;

import com.example.clinic.dto.diagnosis.RequestDiagnosisDto;
import com.example.clinic.models.Diagnosis;
import com.example.clinic.services.DiagnosisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/diagnosis")
@RequiredArgsConstructor
@Tag(name = "Диагнозы")
public class DiagnosisController {
  private final DiagnosisService diagnosisService;

  @Operation(summary = "Создание Диагноз")
  @PostMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Diagnosis createDiagnosis(@RequestBody RequestDiagnosisDto request) {
    return diagnosisService.create(request);
  }

  @Operation(summary = "Удаление Диагноз")
  @DeleteMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteDiagnos(@PathVariable String id) {
    diagnosisService.delete(Long.parseLong(id));
  }

  @Operation(summary = "Обновление Диагноза")
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Diagnosis updateDiagnos(
      @PathVariable String id, @RequestBody RequestDiagnosisDto request) {
    return diagnosisService.update(Long.parseLong(id), request);
  }

  @Operation(summary = "Получение карточки Диагноза")
  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Diagnosis getDiagnos(@PathVariable String id) {
    return diagnosisService.getById(Long.parseLong(id));
  }

  @Operation(summary = "Получение списка Диагноза")
  @GetMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Diagnosis> getDiagnosisList(@RequestParam String limit, @RequestParam String offset) {
    return diagnosisService.getAll(Integer.parseInt(limit), Integer.parseInt(offset));
  }
}
