package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import com.tatu.sistema.interno.tatu_sistema_interno.user.CustomersUsersDTO;

import java.time.LocalDate;

import java.time.LocalTime;

public record ScheduledDTO(Long id, LocalDate scheduledDate, LocalTime scheduledTime, CustomersUsersDTO users) {
    public ScheduledDTO(Scheduled scheduled) {
        this(scheduled.getId(), scheduled.getScheduledDate(), scheduled.getScheduledTime(),
                new CustomersUsersDTO(scheduled.getUsers()));
    }

    public static ScheduledDTO withoutDate(Scheduled scheduled) {
        return new ScheduledDTO(scheduled.getId(), null, scheduled.getScheduledTime(), new CustomersUsersDTO(scheduled.getUsers()));
    }
}
