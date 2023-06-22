package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.service.EventService;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService, EventService eventService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/{event_id}/registrations")
    public ResponseEntity<String> saveRegistration(@RequestBody RegistrationDto registrationDto, @PathVariable("event_id") Long eventId) {
        ResponseEntity<String> response = registrationService.create(registrationDto, eventId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @DeleteMapping("/{registrationId}/events/{eventId}")
    public ResponseEntity<String> deleteRegistrationForEvent(
            @PathVariable Long registrationId,
            @PathVariable Long eventId) {

        try {
            registrationService.deleteRegistrationForEvent(registrationId, eventId);
            return ResponseEntity.ok("Registration is successfully deleted.");

            //   /registration/{registrationId}/events/{eventId}
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    }
