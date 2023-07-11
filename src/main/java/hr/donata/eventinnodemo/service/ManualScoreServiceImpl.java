package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class ManualScoreServiceImpl implements ManualScoreService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;
    private final EventRepository eventRepository;
    private final ScoreService scoreService;

    @Override
    public ResponseEntity<RegistrationDto> scoreRegistration(Long registrationId, Long eventId, ManualScoreDto manualScoreDto) {
        // Checking registration and event (+ exception)
        Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
        Registration registration = null;
        if (registrationOptional.isPresent()) {
            registration = registrationOptional.get();

            Event event = registration.getEvent();
            if (event != null && event.getId() != null && event.getId().equals(eventId)) {
                registrationRepository.findById(registrationId);
            } else {
                throw new IllegalArgumentException("Sorry, there are not registration assigned to this event.");
            }
        }

        // Checking scoring - addition or subtraction + exception
        boolean isAddition = manualScoreDto.isAddition();
        int scoringValue;
        try {
            scoringValue = manualScoreDto.getValue();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid scoring value. " + e.getMessage());
        }

        // Set the updated score
        setScore(registration, isAddition, scoringValue);

        // Saving the score
        saveScore(registration);

        return ResponseEntity.ok(registrationMapper.registrationToRegistrationDto(registration));
    }

    private void setScore(Registration registration, boolean isAddition, int scoringValue) {
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
    }

    private void saveScore(Registration registration) {
        registrationRepository.save(registration);
    }
}



