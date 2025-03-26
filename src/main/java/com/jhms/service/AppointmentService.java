package com.jhms.service;

import com.jhms.dto.AppointmentDto;
import com.jhms.model.Appointment;
import com.jhms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setName(appointmentDto.getName());
        appointment.setAge(appointmentDto.getAge());
        appointment.setEmail(appointmentDto.getEmail());
        appointment.setAddress(appointmentDto.getAddress());
        appointment.setPhoneNumber(appointmentDto.getPhoneNumber());
        appointment.setAdditionalDescription(appointmentDto.getAdditionalDescription());
        
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}