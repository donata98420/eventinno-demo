package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/event/{event_id}/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "")
    public ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registrationDto) {
        ResponseEntity<String> registration = registrationService.create(registrationDto);
        return ResponseEntity.created(URI.create("/registration/" + registration.getBody()))
                .body(registrationDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("You deleted one registration from the database.");
    }
}