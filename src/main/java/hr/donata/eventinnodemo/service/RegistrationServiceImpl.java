package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    private final EventRepository eventRepository;
    private final ScoreService scoreService;

    @Override
    public ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event is not found."));

        ZonedDateTime now = ZonedDateTime.now();

        // Time converting
        if (event.getRegistrationsNotBefore() != null && event.getRegistrationsNotAfter() != null) {
            ZonedDateTime registrationsNotBefore = event.getRegistrationsNotBefore();
            ZonedDateTime registrationsNotAfter = event.getRegistrationsNotAfter();

            if (now.isBefore(registrationsNotBefore) || now.isAfter(registrationsNotAfter)) {
                throw new MethodNotAllowedException("Sorry, registrations for this event are currently closed.", event.getName());
            }
        }

        // Generating UUID
        UUID uuid = UUID.randomUUID();
        registrationDto.setUuid(uuid);

        // Mapping RegistrationDto
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);
        registration.setEvent(event);

        // Saving the registration
        registrationRepository.save(registration);

        // Scoring the registration
        int score = scoreService.calculateScore(registration);
        registration.setScore(score);

        registrationRepository.save(registration);

        return ResponseEntity.status(HttpStatus.CREATED).body("Registration is successfully created.");
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public void deleteRegistrationForEvent(Long registrationId, Long eventId) {
        Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
        if (registrationOptional.isPresent()) {
            Registration registration = registrationOptional.get();

            Event event = registration.getEvent();
            if (event != null && event.getId() != null && event.getId().equals(eventId)) {
                // If event exists, then delete the registration
                registrationRepository.deleteById(registrationId);
            } else {
                throw new IllegalArgumentException("Sorry, the event is not found for the given registration.");
            }
        } else {
            throw new IllegalArgumentException("Sorry, the registration is not found.");
        }
    }

    public static class MethodNotAllowedException extends RuntimeException {
        public MethodNotAllowedException(String message, String name) {
            super(message + (name.isEmpty() ? "" : " Event: " + name));
        }
    }
}


