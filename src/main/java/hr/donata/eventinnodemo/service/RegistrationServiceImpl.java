package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.mapper.RegistrationMapper;
import hr.donata.eventinnodemo.repository.RegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
    }

    @Override
    public void create(RegistrationDto registrationDto) {
        Registration registration = registrationMapper.registrationDtoToRegistration(registrationDto);
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
