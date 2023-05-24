package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EducationDto;
import hr.donata.eventinnodemo.mapper.EducationMapper;
import hr.donata.eventinnodemo.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    public EducationServiceImpl(EducationRepository educationRepository, EducationMapper educationMapper) {
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }

    @Override
    public void create(EducationDto educationDto) {

    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);

    }

}
