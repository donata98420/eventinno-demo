package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.mapper.ExperienceMapper;
import hr.donata.eventinnodemo.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

}