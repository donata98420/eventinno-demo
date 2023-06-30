package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.service.EventService;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    private final RegistrationService registrationService;

    public EventController(EventService eventService, RegistrationService registrationService) {
        this.eventService = eventService;
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/event")
    private ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto) {
        eventService.create(eventDto);
        return ResponseEntity.ok(eventDto);
    }
    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("You deleted one event from the database.");
    }

}