package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Autowired
    ScheduledRepository scheduledRepository;

    public ScheduledDTO saveNewDate(Scheduled scheduled){
        return new ScheduledDTO(scheduledRepository.save(scheduled));
    }

    public List<ScheduledDTO> listAllScheduledDatesByUser(String userId){
        return scheduledRepository.findByUsers_Id(userId).stream().map(ScheduledDTO::new).toList();
    }
    
    public List<ScheduledDTO> listAllScheduledDates(){
       return scheduledRepository.findAllWithCustomer().stream().map(ScheduledDTO::new).toList();
    }

    
}
