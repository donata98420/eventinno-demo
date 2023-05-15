package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.EventRepository;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private final TeamRegistrationRepository teamRegistrationRepository;
    private final TeamRegistrationMapper teamRegistrationMapper;
    private final MentorMapper mentorMapper;
    private final MentorService mentorService;

    private final EventRepository eventRepository;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationMapper teamRegistrationMapper, MentorMapper mentorMapper, MentorService mentorService, EventRepository eventRepository){
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
        this.mentorMapper = mentorMapper;
        this.mentorService = mentorService;
        this.eventRepository = eventRepository;
    }


    @Override
    public void create(TeamRegistrationDto teamRegistrationDto) {
        Event event = eventRepository.findById(teamRegistrationDto.getEventId()).orElseThrow(()
                -> new EntityNotFoundException("Event not found"));

        TeamRegistration teamRegistration =  teamRegistrationMapper.teamRegistrationDtoToTeamRegistration(teamRegistrationDto);
        teamRegistration.setEvent(event);
        teamRegistrationRepository.save(teamRegistration);

    }

    @Override
    public void deleteTeamRegistration(Long id) {
        teamRegistrationRepository.deleteById(id);
    }



}
