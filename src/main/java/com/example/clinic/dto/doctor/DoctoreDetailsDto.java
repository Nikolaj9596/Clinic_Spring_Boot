package com.example.clinic.dto.doctor;

import java.sql.Date;
import lombok.Data;

@Data
public class DoctoreDetailsDto {
  private String firstName;
  private String lastName;
  private String middleName;
  private String avatar;
  private Date dateBirthday;
  private Date dateStartWork;
  private Long profession_id;
}
