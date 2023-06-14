package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.service.TeamRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teamRegistration")
public class TeamRegistrationController {

    private final TeamRegistrationService teamRegistrationService;

    public TeamRegistrationController(TeamRegistrationService teamRegistrationService) {
        this.teamRegistrationService = teamRegistrationService;

    }

    @PostMapping(path = "/save")
    private ResponseEntity<TeamRegistrationDto> saveTeamRegistration(@RequestBody TeamRegistrationDto teamRegistrationDto) {
        teamRegistrationService.create(teamRegistrationDto);
        return ResponseEntity.ok(teamRegistrationDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteTeamRegistration(@PathVariable Long id) {
        teamRegistrationService.deleteTeamRegistration(id);
        return ResponseEntity.ok("You deleted one TeamRegistration from the database.");
    }
}