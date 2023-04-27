package hr.donata.eventinnodemo.controller;


import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.service.TeamRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teamRegistration")
public class TeamRegistrationController {
    private final TeamRegistrationService teamRegistrationService;
    private final TeamRegistrationMapper teamRegistrationMapper;

    public TeamRegistrationController(TeamRegistrationService teamService, TeamRegistrationService teamRegistrationService, TeamRegistrationMapper teamRegistrationMapper) {
        this.teamRegistrationService = teamRegistrationService;

        this.teamRegistrationMapper = teamRegistrationMapper;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<TeamRegistrationDto> saveTeamRegistration(@RequestBody TeamRegistrationDto teamRegistrationDto) {
        teamRegistrationService.create(teamRegistrationDto);
        return ResponseEntity.ok(teamRegistrationDto);
    }


}
