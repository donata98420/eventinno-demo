package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ExperienceDto;

public interface ExperienceService {
    void create(ExperienceDto experienceDto);
    void deleteExperience(Long id);
}
