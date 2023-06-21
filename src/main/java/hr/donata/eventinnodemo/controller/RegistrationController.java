package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/{event_id}/registrations")
    public ResponseEntity<String> saveRegistration(@RequestBody RegistrationDto registrationDto, @PathVariable("event_id") Long eventId) {
        ResponseEntity<String> response = registrationService.create(registrationDto, eventId);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @DeleteMapping(path = "/event/{event_id}/registrations/{registration_id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable("id") Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("You deleted one registration from the database.");
    }
}