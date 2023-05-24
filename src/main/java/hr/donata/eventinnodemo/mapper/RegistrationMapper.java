package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;

public interface RegistrationMapper {
    Registration registrationDtoToRegistration(RegistrationDto registrationDto);
}
