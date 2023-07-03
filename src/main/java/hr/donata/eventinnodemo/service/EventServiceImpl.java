package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.ManualScore;
import hr.donata.eventinnodemo.entity.Personal;
import hr.donata.eventinnodemo.entity.Registration;
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
        return Optional.empty();
    }

    @Override
    public void updateRegistrationScore(Long eventId, Long registrationId, ManualScoreDto manualScoreDto) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isEmpty()) {
            throw new BadRequestException("Event with ID " + eventId + " not found.");
        }

        Event event = eventOptional.get();
        Optional<Registration> registrationOptional = event.getRegistrations().stream()
                .filter(registration -> registration.getId().equals(registrationId))
                .findFirst();

        if (registrationOptional.isEmpty()) {
            throw new BadRequestException("Sorry, but registration with ID " + registrationId + " is not found in the event.");
        }

        Registration registration = registrationOptional.get();
        int scoreIncrement = parseScore(manualScoreDto.getScore());

        // Updating score
        int currentScore = registration.getScore();
        registration.setScore(currentScore + scoreIncrement);

        // Saving ManualScore
        ManualScore manualScore = new ManualScore();
        manualScore.setManualScore(manualScoreDto.getScore());
        manualScore.setComment(manualScoreDto.getComment());
        manualScore.setRegistration(registration);
        registration.getManualScores().add(manualScore);

        // Saving changes
        eventRepository.save(event);
    }

    private int parseScore(String score) {
        try {
            return Integer.parseInt(score);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid score format. Score must be an integer.");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends IllegalArgumentException {
        public BadRequestException(String message) {
            super(message);
        }
    }
}
