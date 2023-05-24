package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EducationDto;

public interface EducationService {


    void create(EducationDto educationDto);

    void deleteEducation(Long id);
}
