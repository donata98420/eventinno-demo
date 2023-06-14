package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.ExperienceDto;
import hr.donata.eventinnodemo.entity.Experience;
import hr.donata.eventinnodemo.entity.Name;
import hr.donata.eventinnodemo.mapper.ExperienceMapper;
import hr.donata.eventinnodemo.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;


    @Override
    public void create(ExperienceDto experienceDto) {
        Experience experience = experienceMapper.experienceDtoToExperience(experienceDto);
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
experienceRepository.deleteById(id);
    }
}