package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.service.EventService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final EventService eventService;

    public RegistrationController(RegistrationService registrationService, EventService eventService) {
        this.registrationService = registrationService;
        this.eventService = eventService;
    }

    @PostMapping("/{eventId}/registrations")
    public ResponseEntity<String> saveRegistration(@RequestBody RegistrationDto registrationDto, @PathVariable("eventId") Long eventId) {
        ResponseEntity<String> response = registrationService.create(registrationDto, eventId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @DeleteMapping("/{registrationId}/events/{eventId}")
    public ResponseEntity<String> deleteRegistrationForEvent(
            @PathVariable Long registrationId,
            @PathVariable Long eventId) {

        try {
            registrationService.deleteRegistrationForEvent(registrationId, eventId);
            return ResponseEntity.ok("Your registration is successfully deleted.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/event/{eventId}/registrations/{registrationId}/score")
    public ResponseEntity<RegistrationDto> scoreRegistration(
            @PathVariable("registrationId") Long registrationId, @PathVariable ("eventId") Long eventId,
            @RequestBody ManualScoreDto manualScoreDto) {

        return registrationService.scoreRegistration(registrationId, eventId, manualScoreDto);
    }

    @GetMapping("/event/{eventId}/registrations/{registrationId}")
    private ResponseEntity<RegistrationDto> getById(@PathVariable Long id) {
        Optional<Registration> optionalRegistration = registrationService.getRegistrationById(id);
        if(optionalRegistration.isPresent()) {
            return ResponseEntity.ok(optionalRegistration.get());
        }
        throw new RuntimeException("This registration does not exist.");
    }
    }


}






