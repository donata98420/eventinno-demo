package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.service.TeamService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {

        this.teamService = teamService;
    }

}
