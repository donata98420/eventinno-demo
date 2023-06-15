package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.PersonalDto;
import hr.donata.eventinnodemo.entity.Personal;
import hr.donata.eventinnodemo.mapper.PersonalMapper;
import hr.donata.eventinnodemo.repository.PersonalRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalService {
    private final PersonalMapper personalMapper;
    private final PersonalRepository personalRepository;
    public PersonalServiceImpl(PersonalMapper personalMapper, PersonalRepository personalRepository) {
        this.personalMapper = personalMapper;
        this.personalRepository = personalRepository;
    }

    @Override
    public void create(PersonalDto personalDto) {
        Personal personal = personalMapper.personalDtoToPersonal(personalDto);
        personalRepository.save(personal);
    }

    @Override
    public void deletePersonal(Long id) {

    }
}
