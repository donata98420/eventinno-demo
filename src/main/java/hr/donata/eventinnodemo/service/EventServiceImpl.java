package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TeamRegistrationService teamRegistrationService;


    @Override
    public void create(EventDto eventDto) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventRepository.save(event);

    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);

    }

    @Override
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends IllegalArgumentException {
        public BadRequestException(String message) {
            super(message);
        }
    }
}
