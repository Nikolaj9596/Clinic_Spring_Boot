package com.example.clinic.controllers;

import com.example.clinic.models.Disease;
import com.example.clinic.services.DiseaseService;
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
@RequestMapping("api/diseases")
@RequiredArgsConstructor
@Tag(name = "Заболевания")
public class DiseaseController {
  private final DiseaseService diseaseService;

  @Operation(summary = "Создание Заболевания")
  @PostMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Disease createDisease(@RequestBody Disease request) {
    Disease disease =
        Disease.builder().name(request.getName()).description(request.getDescription()).build();
    return diseaseService.create(disease);
  }

  @Operation(summary = "Удаление Заболевания")
  @DeleteMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteDisease(@PathVariable String id) {
    diseaseService.delete(Long.parseLong(id));
  }

  @Operation(summary = "Обновление Заболевания")
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Disease updateDisease(@PathVariable String id, @RequestBody Disease request) {
    Disease disease =
        Disease.builder().name(request.getName()).description(request.getDescription()).build();
    return diseaseService.update(Long.parseLong(id), disease);
  }

  @Operation(summary = "Получение карточки Заболевания")
  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Disease getDisease(@PathVariable String id) {
    return diseaseService.getById(Long.parseLong(id));
  }

  @Operation(summary = "Получение списка Заболевании")
  @GetMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Disease> getDiseaseList(@RequestParam String limit, @RequestParam String offset) {
    return diseaseService.getAll(Integer.parseInt(limit), Integer.parseInt(offset));
  }
}
