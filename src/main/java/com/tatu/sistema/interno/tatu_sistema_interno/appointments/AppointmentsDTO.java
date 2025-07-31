package com.tatu.sistema.interno.tatu_sistema_interno.appointments;

import java.time.LocalDateTime;

import com.tatu.sistema.interno.tatu_sistema_interno.user.CostumersUsersDTO;

public record AppointmentsDTO(Long id, LocalDateTime appointmentsDate, CostumersUsersDTO users) {
    public AppointmentsDTO(Appointments appointments){
        this(appointments.getId(), appointments.getAppointmentsDate(), new CostumersUsersDTO(appointments.getUser()));
        
    }
}
