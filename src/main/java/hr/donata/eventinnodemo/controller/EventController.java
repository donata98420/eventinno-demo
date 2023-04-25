package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
