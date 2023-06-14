package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.MentorDto;
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

    @PostMapping(path = "/save")
    private ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registrationDto) {
        registrationService.create(registrationDto);
        return ResponseEntity.ok(registrationDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("You deleted one registration from the database.");
    }
}