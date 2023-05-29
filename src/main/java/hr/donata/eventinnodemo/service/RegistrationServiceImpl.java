package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public void create(RegistrationDto registrationDto) {

    }

    @Override
    public void create(RegistrationDto registrationDto, EventDto eventDto) {
        LocalDateTime now = LocalDateTime.now();

        if (registrationDto.getRegistrationsNotBefore() != null && registrationDto.getRegistrationsNotAfter() != null) {
            LocalDateTime registrationsNotBefore = registrationDto.getRegistrationsNotBefore();
            LocalDateTime registrationsNotAfter = registrationDto.getRegistrationsNotAfter();

            if (now.isBefore(registrationsNotBefore) || now.isAfter(registrationsNotAfter)) {
                throw new MethodNotAllowedException("Registrations for this event are currently closed.", eventDto.getName());
            }
        }

        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public static class MethodNotAllowedException extends RuntimeException {
        public MethodNotAllowedException(String message, String name) {
            super(message + " Event: " + name);
        }
    }
}