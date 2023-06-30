package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.service.EventService;
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

    @PutMapping("/{event_id}/registrations/{registration_id}/score")
    private ResponseEntity<RegistrationDto> updateRegistrationScore(
            @PathVariable("event_id") Long eventId,
            @PathVariable("registration_id") Long registrationId,
            @RequestBody RegistrationDto registrationDto
    ) {
        Optional<Event> eventOptional = eventService.getEventById(eventId);
        Optional<Registration> registrationOptional = registrationService.getRegistrationById(registrationId);

        if (eventOptional.isPresent() && registrationOptional.isPresent()) {
            Event event = eventOptional.get();
            Registration registration = registrationOptional.get();

            // Updating
            String score = registrationDto.getScore();
            if (score.startsWith("+")) {
                int pointsToAdd = Integer.parseInt(score.substring(1));
                registration.setScore(registration.getScore() + pointsToAdd);

            } else if (score.startsWith("-")) {
                int pointsToSubtract = Integer.parseInt(score.substring(1));
                registration.setScore(registration.getScore() - pointsToSubtract);
            } else {

                // HTTP 400
                return ResponseEntity.badRequest().body(registrationDto);
            }

            // Possible comments
            String comment = registrationDto.getComment();
            if (comment != null && !comment.isEmpty()) {
                registration.setComment(comment);
            }

            // Saving
            registrationService.updateRegistration(registration);

            // Returning updated
            return ResponseEntity.ok(registrationDto);
        } else {
            // HTTP 404
            return ResponseEntity.notFound().build();
        }
    }



}