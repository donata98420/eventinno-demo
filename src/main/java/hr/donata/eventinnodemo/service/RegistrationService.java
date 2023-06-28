package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import org.springframework.http.ResponseEntity;


public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId);
    void deleteRegistration(Long id);
    void deleteRegistrationForEvent(Long registrationId, Long eventId);
}
