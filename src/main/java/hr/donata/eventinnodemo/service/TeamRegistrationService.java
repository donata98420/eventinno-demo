package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.Event;
import java.util.List;

public interface TeamRegistrationService {
    void deleteTeamRegistration(Long id);
    void create(TeamRegistrationDto teamRegistrationDto);
    void save(List<TeamRegistrationDto> teams, Event event);
}
