package com.example.clinic.dto.user;

import com.example.clinic.models.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
  private Long id;
  private String name;
  private String email;
  private Role role;
}
