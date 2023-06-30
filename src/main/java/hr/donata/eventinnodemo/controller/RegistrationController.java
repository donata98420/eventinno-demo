package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/{event_id}/registrations")
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
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET - by id
    @GetMapping("/event/{event_id}/registrations/{registration_id}")
    private ResponseEntity<Registration> getById(@PathVariable Long id) {
        Optional<Registration> optionalRegistration = registrationService.getRegistrationById(id);
        if (optionalRegistration.isPresent()) {
            return ResponseEntity.ok(optionalRegistration.get());
        }
        throw new RuntimeException("This registration does not exists.");
    }


}