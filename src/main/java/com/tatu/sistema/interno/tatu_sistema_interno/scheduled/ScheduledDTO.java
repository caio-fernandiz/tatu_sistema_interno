package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.tatu.sistema.interno.tatu_sistema_interno.user.CustomersUsersDTO;

public record ScheduledDTO(Long id, LocalDateTime scheduledDate, CustomersUsersDTO users) {
    public ScheduledDTO(Scheduled scheduled){
        this(scheduled.getId(), scheduled.getScheduledDate(), new CustomersUsersDTO(scheduled.getUsers()));
    }

    public String getFormattedDate(){
        return scheduledDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
