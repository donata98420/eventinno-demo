package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    private final EventRepository eventRepository;
    private final ScoreService scoreService;
    private final ManualScoreService manualScoreService;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, RegistrationMapper registrationMapper, EventRepository eventRepository, ScoreService scoreService, ManualScoreService manualScoreService) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
        this.eventRepository = eventRepository;
        this.scoreService = scoreService;
        this.manualScoreService = manualScoreService;
    }

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
    // Manually scoring
    @Override
    public ResponseEntity<RegistrationDto> scoreRegistration(Long registrationId, Long eventId, ManualScoreDto manualScoreDto) {

        // Checking registration and event (+ exception)
        Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
        Registration registration = registrationOptional.orElseThrow(() -> new EntityNotFoundException("Registration not found.")); // HTTP 404

        Event event = registration.getEvent();
        if (event == null || event.getId() == null || !event.getId().equals(eventId)) {
            throw new IllegalArgumentException("Sorry, but this registration is not assigned to this event."); // HTTP 400
        }

        int manualScore;

        // Checking scoring - addition or subtraction + exception
        if(isAddition(manualScoreDto.getScore())) {
            manualScore = Integer.parseInt(manualScoreDto.getScore().replace("+",""));
            RegistrationDto registrationDto = setScore(registration, true, manualScore, manualScoreDto);
            return ResponseEntity.ok(registrationDto);

        } else if (isSubstraction(manualScoreDto.getScore())) {
            manualScore = Integer.parseInt(manualScoreDto.getScore().replace("-",""));
            RegistrationDto registrationDto = setScore(registration, false, manualScore, manualScoreDto);
            return ResponseEntity.ok(registrationDto);

        } else {
            throw new InvalidScoringValueException ("Ooops. Invalid scoring value: " + manualScoreDto.getScore()); // HTTP 400
        }

    }

    private RegistrationDto setScore(Registration registration, boolean isAddition, int scoringValue, ManualScoreDto manualScoreDto) {
        // Getting the current score
        int currentScore = registration.getScore();

        // Updating the score
        int updatedScore;
        if (isAddition) {
            updatedScore = currentScore + scoringValue;
        } else {
            updatedScore = currentScore - scoringValue;
        }

        // Setting the updated score
        registration.setScore(updatedScore);
        registrationRepository.save(registration);
        manualScoreService.create(manualScoreDto);

        return registrationMapper.registrationToRegistrationDto(registration);

    }

    public boolean isAddition(String score) {
        return score != null && score.startsWith("+");
    }

    public boolean isSubstraction(String score) {
        return score != null && score.startsWith("-");
    }

    public static class InvalidScoringValueException extends IllegalArgumentException {
        public InvalidScoringValueException(String message) {
            super(message);
        }
}}










