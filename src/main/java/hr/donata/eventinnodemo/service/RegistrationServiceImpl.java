package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public void create(RegistrationDto registrationDto) {
        create(registrationDto, null);
    }

    @Override
    public void create(RegistrationDto registrationDto, EventDto eventDto) {
        ZonedDateTime now = ZonedDateTime.now();

        // Check if the registration is within the specified time constraints
        if (registrationDto.getRegistrationsNotBefore() != null && registrationDto.getRegistrationsNotAfter() != null) {
            ZonedDateTime registrationsNotBefore = ZonedDateTime.from(registrationDto.getRegistrationsNotBefore());
            ZonedDateTime registrationsNotAfter = ZonedDateTime.from(registrationDto.getRegistrationsNotAfter());

            if (now.isBefore(registrationsNotBefore) || now.isAfter(registrationsNotAfter)) {
                throw new MethodNotAllowedException("Registrations for this event are currently closed.", eventDto != null ? eventDto.getName() : "");
            }
        }

        // Generate a UUID for the registration
        registrationDto.setUuid(UUID.randomUUID());

        // Map the RegistrationDto to the Registration entity
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);

        // Save the registration in the repository
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public static class MethodNotAllowedException extends RuntimeException {
        public MethodNotAllowedException(String message, String name) {
            super(message + (name.isEmpty() ? "" : " Event: " + name));
        }
    }
}