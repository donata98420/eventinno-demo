import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import hr.donata.eventinnodemo.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public ResponseEntity<String> create(RegistrationDto registrationDto) {
        return create(registrationDto, null);
    }

    @Override
    public ResponseEntity<String> create(RegistrationDto registrationDto, EventDto eventDto) {
        ZonedDateTime now = ZonedDateTime.now();

        // Time converting
        if (registrationDto.getRegistrationsNotBefore() != null && registrationDto.getRegistrationsNotAfter() != null) {
            ZonedDateTime registrationsNotBefore = ZonedDateTime.of(LocalDateTime.from(registrationDto.getRegistrationsNotBefore()), ZoneId.systemDefault());
            ZonedDateTime registrationsNotAfter = ZonedDateTime.of(LocalDateTime.from(registrationDto.getRegistrationsNotAfter()), ZoneId.systemDefault());

            if (now.isBefore(registrationsNotBefore) || now.isAfter(registrationsNotAfter)) {
                throw new MethodNotAllowedException("Sorry, registrations for this event are currently closed.", eventDto != null ? eventDto.getName() : "");
            }
        }

        // Generating a UUID
        registrationDto.setUuid(UUID.randomUUID());

        // Mapping the RegistrationDto
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);

        registrationRepository.save(registration);

        // Returning the HTTP response with status code 201 "Created"
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration created successfully.");
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