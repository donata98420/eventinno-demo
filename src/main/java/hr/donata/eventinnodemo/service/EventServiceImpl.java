package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
private final EventRepository eventRepository;
private final EventMapper eventMapper;
    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public void create(EventDto eventDto) {
        Event event =  eventMapper.eventDtoToEvent(eventDto);
        eventRepository.save(event);
        eventRepository.save(eventDto);
    }



}
