package com.example.clinic.dto.client;

import java.sql.Date;
import lombok.Data;

@Data
public class CreateClientDto {
  private String firstName;
  private String lastName;
  private String middleName;
  private String avatar;
  private Date dateBirthday;
  private String address;
}
