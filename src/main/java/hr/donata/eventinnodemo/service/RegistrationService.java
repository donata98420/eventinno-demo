package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.ManualScore;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId);
    void deleteRegistration(Long id);
    void deleteRegistrationForEvent(Long registrationId, Long eventId);

    void scoreRegistration(Long registrationId, ManualScore manualScore);
}
