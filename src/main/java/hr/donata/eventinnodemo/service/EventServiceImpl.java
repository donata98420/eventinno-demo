package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
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
            if (eventRepository.findByName(eventDto.getName()).isPresent()) {
                throw new BadRequestException("Sorry, this team name already exists.");
            }

            List<TeamRegistrationDto> teamRegistrationDtos = eventDto.getTeams();

            if (teamRegistrationDtos.stream().map(TeamRegistrationDto::getName).distinct().count() != teamRegistrationDtos.size()) {
                throw new BadRequestException("Multiple teams have the same name.");
            }

            Event event = eventMapper.eventDtoToEvent(eventDto);
            event = eventRepository.save(event);

            for (TeamRegistrationDto teamRegistrationDto : teamRegistrationDtos) {
                teamRegistrationDto.setEventId(event.getId());
                teamRegistrationService.create(teamRegistrationDto);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("This event name already exists. Try with another one.");
        } catch (BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Oops. An unexpected error occurred.", e);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends IllegalArgumentException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}