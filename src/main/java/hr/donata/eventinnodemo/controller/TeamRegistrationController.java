package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.service.TeamRegistrationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamRegistrationController {
    private final TeamRegistrationService teamService;

    public TeamRegistrationController(TeamRegistrationService teamService) {

        this.teamService = teamService;
    }



}
