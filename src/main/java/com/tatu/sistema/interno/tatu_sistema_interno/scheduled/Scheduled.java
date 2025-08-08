package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tatu.sistema.interno.tatu_sistema_interno.user.Users;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;  
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "scheduled")
@Entity(name = "scheduled")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Scheduled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate scheduledDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime scheduledTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}