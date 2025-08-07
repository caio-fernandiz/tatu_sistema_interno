package com.tatu.sistema.interno.tatu_sistema_interno.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tatu.sistema.interno.tatu_sistema_interno.user.Users;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
@RequestMapping("/schedule")
public class ScheduledController {

    @Autowired
    private final ScheduledService scheduledService;

    public ScheduledController(ScheduledService scheduledService) {
        this.scheduledService = scheduledService;
    }

    @GetMapping("/show/alldates")
    public ResponseEntity<List<ScheduledDTO>> listAllScheduledDates() {
        List<ScheduledDTO> scheduledDates = scheduledService.listAllScheduledDates();
        return new ResponseEntity<>(scheduledDates, HttpStatus.OK);
    }

    @GetMapping("/show/datesforuser/{userId}")
    public ResponseEntity<List<ScheduledDTO>> listAllScheduledDatesByUser(@PathVariable String userId) {
        List<ScheduledDTO> scheduleDatesForUser = scheduledService.listAllScheduledDatesByUser(userId);
        return new ResponseEntity<>(scheduleDatesForUser, HttpStatus.OK);
    }

    @GetMapping("/show/schedules/{scheduledDate}")
    public ResponseEntity<List<ScheduledDTO>> listAllSchedulesByDate (@PathVariable LocalDateTime scheduledDate) {
        List<ScheduledDTO> scheduledForDate = scheduledService.listAllSchedulesByDate(scheduledDate);
        return new ResponseEntity<>(scheduledForDate, HttpStatus.OK);
    }
    

    @PostMapping("/newdate")
    public ResponseEntity<ScheduledDTO> saveNewDate(@Valid @RequestBody Scheduled scheduled) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Users loggedUser = (Users) authentication.getPrincipal();
        scheduled.setUsers(loggedUser);
        ScheduledDTO newDateScheduled = scheduledService.saveNewDate(scheduled);
        return new ResponseEntity<>(newDateScheduled, HttpStatus.OK);
    }
}
