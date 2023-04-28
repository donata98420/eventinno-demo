package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto) {
        eventService.create(eventDto);
        return ResponseEntity.ok(eventDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("You deleted one event from database.");
    }

}
