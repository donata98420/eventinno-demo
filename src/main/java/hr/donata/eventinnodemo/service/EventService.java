package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;

import java.util.Optional;

public interface EventService {

    void create(EventDto eventDto);
    void deleteEvent(Long id);

    Optional<Event> getEventById(Long eventId);
}
