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