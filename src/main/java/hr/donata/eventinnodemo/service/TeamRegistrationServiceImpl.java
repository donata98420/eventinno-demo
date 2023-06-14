package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private final TeamRegistrationRepository teamRegistrationRepository;
    private final TeamRegistrationMapper teamRegistrationMapper;
    private final EventRepository eventRepository;
    private final MentorService mentorService;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRegistrationRepository,
                                       TeamRegistrationMapper teamRegistrationMapper,
                                       EventRepository eventRepository,
                                       MentorService mentorService) {
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
        this.eventRepository = eventRepository;
        this.mentorService = mentorService;
    }

    @Override
    public void create(TeamRegistrationDto teamRegistrationDto) {
        Event event = eventRepository.findById(teamRegistrationDto.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found."));

        validateMentors(teamRegistrationDto.getMentors());

        TeamRegistration teamRegistration = teamRegistrationMapper.teamRegistrationDtoToTeamRegistration(teamRegistrationDto);
        teamRegistration.setEvent(event);
        teamRegistrationRepository.save(teamRegistration);

        for (MentorDto mentorDto : teamRegistrationDto.getMentors()) {
            mentorDto.setTeamRegistrationId(teamRegistration.getId());
            mentorService.create(mentorDto);
        }
    }

    private void validateMentors(List<MentorDto> mentorDtos) {
        long distinctEmailCount = mentorDtos.stream()
                .map(MentorDto::getEmail)
                .distinct()
                .count();

        if (distinctEmailCount != mentorDtos.size()) {
            throw new DuplicateMentorEmailException("Multiple mentors have the same email.");
        }
    }

    @Override
    public void deleteTeamRegistration(Long id) {
        teamRegistrationRepository.deleteById(id);
    }

    public static class BadRequestException extends IllegalArgumentException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class DuplicateMentorEmailException extends BadRequestException {
        public DuplicateMentorEmailException(String message) {
            super(message);
        }
    }
}