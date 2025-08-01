package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "mode")
@Entity(name = "mode")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")

public class Mode {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nomeDaCoisa;
    private String identificador;
    private Integer quantidade;
}
