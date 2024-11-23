package com.example.clinic.controllers;

import com.example.clinic.dto.client.RequestClientDto;
import com.example.clinic.models.Client;
import com.example.clinic.services.ClientService;
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
@RequestMapping("api/clients")
@RequiredArgsConstructor
@Tag(name = "Клиенты")
public class ClientController {
  private final ClientService clientService;
  private final ModelMapper mapper;

  @Operation(summary = "Создание Пациента")
  @PostMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Client createClient(@RequestBody RequestClientDto request) {
    Client client =
        Client.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .middleName(request.getMiddleName())
            .avatar(request.getAvatar())
            .dateBirthday(request.getDateBirthday())
            .address(request.getAddress())
            .build();
    return clientService.create(client);
  }

  @Operation(summary = "Удаление Пациента")
  @DeleteMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void deleteClient(@PathVariable String id) {
    clientService.delete(Long.parseLong(id));
  }

  @Operation(summary = "Обновление Пациента")
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Client updateClient(@PathVariable String id, @RequestBody RequestClientDto request) {

    Client client =
        Client.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .middleName(request.getMiddleName())
            .avatar(request.getAvatar())
            .dateBirthday(request.getDateBirthday())
            .address(request.getAddress())
            .build();
    return clientService.update(Long.parseLong(id), client);
  }

  @Operation(summary = "Получение карточки Пациента")
  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Client getClient(@PathVariable String id) {
    return clientService.getById(Long.parseLong(id));
  }

  @Operation(summary = "Получение списка Пациента")
  @GetMapping("")
  @SecurityRequirement(name = "bearerAuth")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<Client> getClientList(@RequestParam String limit, @RequestParam String offset) {
    return clientService.getAll(Integer.parseInt(limit), Integer.parseInt(offset));
  }
}
