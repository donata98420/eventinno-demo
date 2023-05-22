package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import org.springframework.stereotype.Service;


public interface RegistrationService {
    void create(RegistrationDto registrationDto);
    void deleteRegistration(Long id);
}
