package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.Registration;
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

    public ResponseEntity<RegistrationDto> manualScoreRegistration(Long registrationId, Long eventId, ManualScoreDto manualScoreDto) {

        // Checking registration and event (+ exception)
        Optional<Registration> registrationOptional = registrationRepository.findById(registrationId);
        Registration registration = registrationOptional.orElseThrow(() -> new IllegalArgumentException("Registration not found."));

        Event event = registration.getEvent();
        if (event == null || event.getId() == null || !event.getId().equals(eventId)) {
            throw new IllegalArgumentException("Registration is not assigned to this event.");
        }

        // Checking scoring - addition or subtraction + exception
        boolean isAddition = manualScoreDto.isAddition();
        int scoringValue = manualScoreDto.getValue();

        // Set the updated score
        private void setScore setScore(registration, isAddition, scoringValue);

        // Saving the score
        private void saveScore saveScore(registration);


        (Registration registration,boolean isAddition, int scoringValue){
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

        (Registration registration){
            registrationRepository.save(registration);
        }
    }






