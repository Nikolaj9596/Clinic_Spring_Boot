package com.example.clinic.controllers;

import com.example.clinic.dto.doctor_appointment.RequestDoctorAppointmentDto;
import com.example.clinic.models.DoctorAppointment;
import com.example.clinic.services.DoctorAppointmentService;
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
@RequestMapping("api/appointments")
@RequiredArgsConstructor
@Tag(name = "Запись на прием")
public class DoctorAppointmentController {
  private final DoctorAppointmentService doctorAppointmentService;

  @Operation(summary = "Создание Записи на прием")
  @PostMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public DoctorAppointment createDoctorAppointment(@RequestBody RequestDoctorAppointmentDto request) {
    return doctorAppointmentService.create(request);
  }

  @Operation(summary = "Удаление Записи на прием")
  @DeleteMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteDiagnos(@PathVariable String id) {
    doctorAppointmentService.delete(Long.parseLong(id));
  }

  @Operation(summary = "Обновление Записи на прием")
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public DoctorAppointment updateDiagnos(
      @PathVariable String id, @RequestBody RequestDoctorAppointmentDto request) {
    return doctorAppointmentService.update(Long.parseLong(id), request);
  }

  @Operation(summary = "Получение карточки Записи на прием")
  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public DoctorAppointment getDiagnos(@PathVariable String id) {
    return doctorAppointmentService.getById(Long.parseLong(id));
  }

  @Operation(summary = "Получение списка записей на прием")
  @GetMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<DoctorAppointment> getDoctorAppointmentList(@RequestParam String limit, @RequestParam String offset) {
    return doctorAppointmentService.getAll(Integer.parseInt(limit), Integer.parseInt(offset));
  }
}
