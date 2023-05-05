package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{
private final  EventRepository eventRepository;
private final EventMapper eventMapper;
private final TeamRegistrationService teamRegistrationService;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper, TeamRegistrationService teamRegistrationService) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.teamRegistrationService = teamRegistrationService;
    }



    @Override
    public void create(EventDto eventDto) {
        try {
            List<TeamRegistrationDto> teamRegistrationDtos = eventDto.getTeams();
            Event event = eventMapper.eventDtoToEvent(eventDto);
            for (TeamRegistrationDto teamRegistrationDto : teamRegistrationDtos) {
                teamRegistrationService.create(teamRegistrationDto);
            }
            eventRepository.save(event);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("This event name already exists. Try another one.");
        }
    }

    @Override
    public void deleteEvent(Long id) {

        eventRepository.deleteById(id);
    }

}