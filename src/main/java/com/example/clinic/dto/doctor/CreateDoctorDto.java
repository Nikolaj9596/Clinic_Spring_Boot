package com.example.clinic.dto.doctor;

import java.sql.Date;
import lombok.Data;

@Data
public class CreateDoctorDto {
  private String firstName;
  private String lastName;
  private String middleName;
  private String avatar;
  private Date dateBirthday;
  private Date dateStartWork;
  private Long professionId;
}
