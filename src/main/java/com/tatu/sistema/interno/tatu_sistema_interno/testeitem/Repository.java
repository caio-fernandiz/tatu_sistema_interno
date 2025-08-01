package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Repository extends JpaRepository <Mode, Long>{
    boolean existsByIdentificador(String identificador);
    Optional<Mode> findByIdentificador(String identificador);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Mode m WHERE m.identificador = :identificador")
    void dedeleteByIdentificador(String identificador);

}
