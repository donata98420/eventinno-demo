package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto, Long eventId);
    void deleteRegistration(Long id);
    void deleteRegistrationForEvent(Long registrationId, Long eventId);
    Optional<Registration> getRegistrationById(Long id);
}
