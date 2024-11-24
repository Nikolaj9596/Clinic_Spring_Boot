package com.example.clinic.services;

import com.example.clinic.dto.doctor_appointment.RequestDoctorAppointmentDto;
import com.example.clinic.models.DoctorAppointment;
import com.example.clinic.repositories.ClientRepository;
import com.example.clinic.repositories.DoctorAppointmentRepository;
import com.example.clinic.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorAppointmentService {
  private final DoctorAppointmentRepository doctorAppointmentRepository;
  private final DoctorRepository doctorRepository;
  private final ClientRepository clientRepository;

  public DoctorAppointment create(RequestDoctorAppointmentDto request) {
    DoctorAppointment appointment =
        DoctorAppointment.builder()
            .startDateAppointment(request.getStartDateAppointment())
            .endDateAppointment(request.getEndDateAppointment())
            .client(clientRepository.getById(request.getClientId()))
            .doctor(doctorRepository.getById(request.getDoctorId()))
            .build();
    return doctorAppointmentRepository.save(appointment);
  }

  public DoctorAppointment update(long appointment_id, RequestDoctorAppointmentDto request) {
    if (!doctorAppointmentRepository.existsById(appointment_id)) {
      throw new RuntimeException("Запись на прием не существует");
    }

    DoctorAppointment appointment =
        DoctorAppointment.builder()
            .startDateAppointment(request.getStartDateAppointment())
            .endDateAppointment(request.getEndDateAppointment())
            .client(clientRepository.getById(request.getClientId()))
            .doctor(doctorRepository.getById(request.getDoctorId()))
            .build();
    return doctorAppointmentRepository.save(appointment);
  }

  public void delete(Long appointment_id) {
    doctorAppointmentRepository.deleteById(appointment_id);
  }

  public DoctorAppointment getById(Long appointment_id) {
    Optional<DoctorAppointment> optionalDoctorAppointment =
        doctorAppointmentRepository.findById(appointment_id);
    DoctorAppointment appointment =
        optionalDoctorAppointment.orElseThrow(
            () -> new RuntimeException("Запись на прием не существует"));

    appointment.setClient(clientRepository.findById(appointment.getClient().getId()).orElse(null));
    appointment.setDoctor(doctorRepository.findById(appointment.getDoctor().getId()).orElse(null));
    return appointment;
  }

  public List<DoctorAppointment> getAll(Integer limit, Integer offset) {
    PageRequest pageRequest = PageRequest.of(offset, limit);
    Page<DoctorAppointment> page = doctorAppointmentRepository.findAll(pageRequest);
    List<DoctorAppointment> appointmentes = page.getContent();

    for (DoctorAppointment doctorAppointment : appointmentes) {
      doctorAppointment.setClient(
          clientRepository.findById(doctorAppointment.getClient().getId()).orElse(null));
      doctorAppointment.setDoctor(
          doctorRepository.findById(doctorAppointment.getDoctor().getId()).orElse(null));
    }

    return appointmentes;
  }
}
