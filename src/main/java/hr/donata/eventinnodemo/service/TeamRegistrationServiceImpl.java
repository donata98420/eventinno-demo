package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Mentor;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private  final TeamRegistrationRepository teamRegistrationRepository;
    private  final TeamRegistrationMapper teamRegistrationMapper;
    private final MentorMapper mentorMapper;
    private final MentorService mentorService;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationMapper teamRegistrationMapper, MentorMapper mentorMapper, MentorService mentorService){
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
        this.mentorMapper = mentorMapper;
        this.mentorService = mentorService;
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
