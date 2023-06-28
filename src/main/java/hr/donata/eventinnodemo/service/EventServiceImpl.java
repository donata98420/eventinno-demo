package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.EventMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final TeamRegistrationService teamRegistrationService;

    @Override
    public void create(EventDto eventDto) {
        try {
            if (eventRepository.findByName(eventDto.getName()).isPresent()) {
                throw new BadRequestException("Sorry, this event name already exists. Use another one.");
            }

            // Converting
            String registrationsNotAfterString = eventDto.getRegistrationsNotAfter()
                    .format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
            String confirmationNotAfterString = eventDto.getConfirmationNotAfter()
                    .format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
            String registrationsNotBeforeString = eventDto.getRegistrationsNotBefore()
                    .format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

            // Creating Event
            Event event = eventMapper.eventDtoToEvent(eventDto);
            event.setRegistrationsNotAfter(ZonedDateTime.parse(registrationsNotAfterString));
            event.setConfirmationNotAfter(ZonedDateTime.parse(confirmationNotAfterString));
            event.setRegistrationsNotBefore(ZonedDateTime.parse(registrationsNotBeforeString));

            // Saving event
            event = eventRepository.save(event);

            // Saving TeamRegistration
            teamRegistrationService.save(eventDto.getTeams(), event);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("This event name already exists. Try with another one.", e);
        } catch (Exception e) {
            throw new RuntimeException("Oops. An unexpected error occurred.", e);
        }
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends IllegalArgumentException {
        public BadRequestException(String message) {
            super(message);
        }
    }
}