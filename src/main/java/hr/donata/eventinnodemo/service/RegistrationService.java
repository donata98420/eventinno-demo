package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId);
    void deleteRegistration(Long id);
    void deleteRegistrationForEvent(Long registrationId, Long eventId);
}
