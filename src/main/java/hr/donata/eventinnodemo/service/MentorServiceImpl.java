package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.entity.Mentor;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.repository.MentorRepository;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final TeamRegistrationRepository teamRegistrationRepository;
    private final MentorMapper mentorMapper;

    public MentorServiceImpl(MentorRepository mentorRepository,
                             TeamRegistrationRepository teamRegistrationRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.mentorMapper = mentorMapper;
    }

    @Override
    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }

    @Override
    public void create(MentorDto mentorDto) {
        if (mentorRepository.findByEmail(mentorDto.getEmail()).isPresent()) {
            throw new BadRequestException("Sorry, this mentor email already exists.");
        }

        TeamRegistration teamRegistration = teamRegistrationRepository.findById(mentorDto.getTeamRegistrationId())
                .orElseThrow(() -> new NotFoundException("Team registration is not found."));

        Mentor mentor = mentorMapper.mentorDtoToMentor(mentorDto);
        mentor.setTeamRegistration(teamRegistration);
        mentorRepository.save(mentor);
    }

    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}