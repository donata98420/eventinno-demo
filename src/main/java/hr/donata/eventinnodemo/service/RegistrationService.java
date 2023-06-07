package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import org.springframework.http.ResponseEntity;


public interface RegistrationService {
    ResponseEntity<String> create(RegistrationDto registrationDto);

    abstract ResponseEntity<String> create(RegistrationDto registrationDto, EventDto eventDto);

    void deleteRegistration(Long id);


}
