package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.controller.TeamRegistrationController;
import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.repository.TeamRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamRegistrationServiceImpl implements TeamRegistrationService {
    private  TeamRegistrationRepository teamRegistrationRepository;
    private  TeamRegistrationMapper teamRegistrationMapper;
    private  MentorService mentorService;
    private  TeamRegistrationController teamRegistration;

    public TeamRegistrationServiceImpl(TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationMapper teamRegistrationMapper, MentorService mentorService, TeamRegistrationController teamRegistration) {
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
        this.mentorService = mentorService;
        this.teamRegistration = teamRegistration;
    }

    @Autowired
    public void setDependencies(TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationMapper teamRegistrationMapper, MentorService mentorService) {
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationMapper = teamRegistrationMapper;
        this.mentorService = mentorService;
    }

    @Override
    public void create(TeamRegistrationDto teamRegistrationDto) {
        TeamRegistration teamRegistration =  teamRegistrationMapper.teamRegistrationDtoToTeamRegistration(teamRegistrationDto);
        teamRegistrationRepository.save(teamRegistration);
    }


    @Override
    public void create(EventDto eventDto) {
        List<MentorDto> mentorDtos = eventDto.getMentors();
        TeamRegistrationDto teamRegistrationDto = eventDto.getTeamRegistrationDto();
        TeamRegistration teamRegistration = teamRegistrationMapper.teamRegistrationDtoToTeamRegistration(teamRegistrationDto);
        for (MentorDto mentorDto : mentorDtos) {
            mentorService.create(mentorDto);
        }
        teamRegistrationRepository.save(teamRegistration);
    }
    @Override
    public void deleteTeamRegistration(Long id) {
        teamRegistrationRepository.deleteById(id);
    }




}
