package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TeamRegistrationService teamRegistrationService;

    @Override
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void create(EventDto eventDto) {
        try {
            if (eventRepository.findByName(eventDto.getName()).isPresent()) {
                throw new BadRequestException("Sorry, this event name already exists. Use another one.");
            }

            if (eventDto.getRegistrationsNotBefore() != null && eventDto.getRegistrationsNotAfter() != null) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime registrationsNotBefore = eventDto.getRegistrationsNotBefore();
                LocalDateTime registrationsNotAfter = eventDto.getRegistrationsNotAfter();

                if (now.isBefore(registrationsNotBefore) || now.isAfter(registrationsNotAfter)) {
                    throw new MethodNotAllowedException("Registrations for this event are currently closed.", eventDto.getName());
                }
            }

            List<TeamRegistrationDto> teamRegistrationDtos = eventDto.getTeams();

            if (teamRegistrationDtos.stream().map(TeamRegistrationDto::getName).distinct().count() != teamRegistrationDtos.size()) {
                throw new BadRequestException("Sorry, multiple teams have the same name.");
            }

            Event event = eventMapper.eventDtoToEvent(eventDto);
            event = eventRepository.save(event);

            for (TeamRegistrationDto teamRegistrationDto : teamRegistrationDtos) {
                teamRegistrationDto.setEventId(event.getId());
                teamRegistrationService.create(teamRegistrationDto);
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("This event name already exists. Try with another one.", e);
        } catch (Exception e) {
            throw new RuntimeException("Oops. An unexpected error occurred.", e);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends IllegalArgumentException {
        private String errorMessage;

        public BadRequestException(String message) {
            super(message);
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    // If event does not accept registrations
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public static class MethodNotAllowedException extends RuntimeException {
        public MethodNotAllowedException(String message, String eventName) {
            super(message + " Event: " + eventName);
        }
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}