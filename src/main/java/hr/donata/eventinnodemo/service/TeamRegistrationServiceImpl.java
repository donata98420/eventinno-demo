package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private final TeamRegistrationRepository teamRegistrationRepository;
    private final TeamRegistrationMapper teamRegistrationMapper;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationMapper teamRegistrationMapper) {
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
    }

    @Override
    public void create(TeamRegistrationDto teamRegistrationDto) {
        TeamRegistration teamRegistration =  teamRegistrationMapper.teamRegistrationDtoToTeamRegistration(teamRegistrationDto);
        teamRegistrationRepository.save(teamRegistration);
    }

    @Override
    public void deleteTeamRegistration(Long id) {
        teamRegistrationRepository.deleteById(id);
    }

}
