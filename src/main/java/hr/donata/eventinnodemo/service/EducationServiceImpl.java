package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EducationDto;
import hr.donata.eventinnodemo.entity.Education;
import hr.donata.eventinnodemo.mapper.EducationMapper;
import hr.donata.eventinnodemo.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    @Override
    public void create(EducationDto educationDto) {
        Education education = educationMapper.educationDtoToEducation(educationDto);
        education.setId(1L); // assigning ID
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);

    }

}
