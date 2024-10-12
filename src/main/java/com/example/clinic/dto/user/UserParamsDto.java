package com.example.clinic.dto.user;

import com.example.clinic.models.Role;
import lombok.Data;

@Data
public class UserParamsDto {
  private String name;
  private String surname;
  private String lastname;
  private String email;
  private Role role;
}
