package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
@RequestMapping("/schedule")
public class ScheduledController {

    @Autowired
    private final ScheduledService scheduledService;

    public ScheduledController(ScheduledService scheduledService){
        this.scheduledService = scheduledService;
    }

    @GetMapping("/show/alldates")
    public ResponseEntity <List<ScheduledDTO>> listAllScheduledDates () {
        List<ScheduledDTO> scheduledDates = scheduledService.listAllScheduledDates();
        return new ResponseEntity<>(scheduledDates, HttpStatus.OK);
    }

    @PostMapping("/newdate")
    public ResponseEntity<ScheduledDTO> saveNewDate (@Valid @RequestBody Scheduled scheduled) {
        
        ScheduledDTO newDateScheduledDTO = scheduledService.saveNewDate(scheduled);
        
        return new ResponseEntity<>(newDateScheduledDTO, HttpStatus.OK);
    }    
}
