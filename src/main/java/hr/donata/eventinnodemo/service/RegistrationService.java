package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;

import java.time.chrono.ChronoLocalDateTime;
import java.util.UUID;


public interface RegistrationService {
    void create(RegistrationDto registrationDto);

    abstract void create(RegistrationDto registrationDto, EventDto eventDto);

    void deleteRegistration(Long id);


}
