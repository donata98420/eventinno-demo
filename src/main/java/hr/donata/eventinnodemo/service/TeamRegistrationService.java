package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.TeamRegistration;

public interface TeamRegistrationService {

    void create(TeamRegistrationDto teamRegistrationDto);
    void deleteTeamRegistration(Long id);
    void create(EventDto eventDto);
}
