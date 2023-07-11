package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.service.EventService;
import org.springframework.http.ResponseEntity;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final EventService eventService;

    public RegistrationController(RegistrationService registrationService, EventService eventService) {
        this.registrationService = registrationService;
        this.eventService = eventService;
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


}






