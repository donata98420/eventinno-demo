package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private final TeamRegistrationRepository teamRepository;
    private final TeamRegistrationMapper teamRegistrationMapper;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRepository, TeamRegistrationMapper teamRegistrationMapper) {
        this.teamRepository = teamRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
    }


    @Override
    public void create(TeamRegistrationDto teamRegistrationDto) {

    }
}
