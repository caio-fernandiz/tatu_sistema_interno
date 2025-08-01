package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface Repository extends JpaRepository <Mode, String>{
    boolean existsByIdentificador(String identificador);
    Optional<Mode> findByIdentificador(String identificador);
    
    @Transactional
    @Modifying
    void deleteByIdentificador(String identificador);

}
