package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.PersonalDto;

public interface PersonalService {
    void create(PersonalDto personalDto);
    void deletePersonal(Long id);
}
