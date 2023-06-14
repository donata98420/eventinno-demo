package hr.donata.eventinnodemo.service;


import hr.donata.eventinnodemo.dto.TeamRegistrationDto;

public interface TeamRegistrationService {


    void deleteTeamRegistration(Long id);

    void create(TeamRegistrationDto teamRegistrationDto);
}
