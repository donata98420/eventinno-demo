package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;

public interface TeamRegistrationService {

    void create(TeamRegistrationDto teamRegistrationDto);
    void deleteTeamRegistration(Long id);
    void create(EventDto eventDto);
}
