package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId);
    void deleteRegistration(Long id);
    void deleteRegistrationForEvent(Long registrationId, Long eventId);
    ResponseEntity<Registration> scoreRegistration(Long registrationId, ManualScoreDto manualScore);
}
