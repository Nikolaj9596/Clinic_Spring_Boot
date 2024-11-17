package com.example.clinic.controllers;

import com.example.clinic.dto.doctor.CreateDoctorDto;
import com.example.clinic.models.Doctor;
import com.example.clinic.models.Profession;
import com.example.clinic.services.DoctorService;
import com.example.clinic.services.ProfessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
@RequestMapping("api/doctors")
@RequiredArgsConstructor
@Tag(name = "Врачи")
public class DoctorController {
  private final DoctorService doctorService;
  private final ProfessionService professionService;
  private final ModelMapper mapper;

  @Operation(summary = "Создание Врача")
  @PostMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Doctor createDoctor(@RequestBody CreateDoctorDto request) {
    Profession profession = professionService.getById(request.getProfessionId());
    Doctor doctor =
        Doctor.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .middleName(request.getMiddleName())
            .avatar(request.getAvatar())
            .dateBirthday(request.getDateBirthday())
            .dateStartWork(request.getDateStartWork())
            .profession(profession)
            .build();
    return doctorService.create(doctor);
  }

  @Operation(summary = "Удаление Врача")
  @DeleteMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteDoctor(@PathVariable String id) {
    doctorService.delete(Long.parseLong(id));
  }

  @Operation(summary = "Обновление Врача")
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Doctor updateDoctor(@PathVariable String id, @RequestBody CreateDoctorDto request) {

    Profession profession = professionService.getById(request.getProfessionId());
    Doctor doctor =
        Doctor.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .middleName(request.getMiddleName())
            .avatar(request.getAvatar())
            .dateBirthday(request.getDateBirthday())
            .dateStartWork(request.getDateStartWork())
            .profession(profession)
            .build();
    return doctorService.update(Long.parseLong(id), doctor);
  }

  @Operation(summary = "Получение карточки Врача")
  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Doctor getDoctor(@PathVariable String id) {
    return doctorService.getById(Long.parseLong(id));
  }

  @Operation(summary = "Получение списка Врачей")
  @GetMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Doctor> getDoctorList(@RequestParam String limit, @RequestParam String offset) {
    return doctorService.getAll(Integer.parseInt(limit), Integer.parseInt(offset));
  }
}
