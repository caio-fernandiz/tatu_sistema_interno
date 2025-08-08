package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ScheduledRepository extends JpaRepository <Scheduled, Long>{
    @Query("SELECT a FROM scheduled a JOIN FETCH a.users")
    List<Scheduled> findAllWithCustomer();
    List<Scheduled> findByUsers_Id (String userId);
    List<Scheduled> findByScheduledDate (LocalDate scheduledDate);
    
}
