package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.entity.Mentor;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.repository.MentorRepository;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;
    private final TeamRegistrationRepository teamRegistrationRepository;

    public MentorServiceImpl(MentorRepository mentorRepository, MentorMapper mentorMapper, TeamRegistrationRepository teamRegistrationRepository) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
        this.teamRegistrationRepository = teamRegistrationRepository;
    }

    @Override
    public void deleteMentor(Long id) {

        mentorRepository.deleteById(id);
    }

    @Override
    public void create(MentorDto mentorDto) {
        try {
            if (mentorRepository.findByEmail(mentorDto.getEmail()).isPresent()) {
                throw new BadRequestException("Sorry, this mentor email already exists.");
            }

            TeamRegistration teamRegistration =  teamRegistrationRepository.findById(mentorDto.getTeamRegistrationId())
                    .orElseThrow(() -> new NotFoundException("Event is not found."));

            Mentor mentor = mentorMapper.mentorDtoToMentor(mentorDto);
            mentor.setTeamRegistration(teamRegistration);
            mentorRepository.save(mentor);

        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("This mentor email already exists. Try with another one.");
        } catch (BadRequestException | NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Oooops. An unexpected error occurred.", e);
        }
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