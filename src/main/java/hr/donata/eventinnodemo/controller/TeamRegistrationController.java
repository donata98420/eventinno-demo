import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.mapper.TeamRegistrationMapper;
import hr.donata.eventinnodemo.service.TeamRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teamRegistration")
public class TeamRegistrationController {
    private final TeamRegistrationService teamRegistrationService;
    private final TeamRegistrationMapper teamRegistrationMapper;

    public TeamRegistrationController(TeamRegistrationService teamRegistrationService,  TeamRegistrationMapper teamRegistrationMapper) {
        this.teamRegistrationService = teamRegistrationService;
        this.teamRegistrationMapper = teamRegistrationMapper;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<TeamRegistrationDto> saveTeamRegistration(@RequestBody TeamRegistrationDto teamRegistrationDto) {
        teamRegistrationService.create(teamRegistrationDto);
        return ResponseEntity.ok(teamRegistrationDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteTeamRegistration(@PathVariable Long id) {
        teamRegistrationService.deleteTeamRegistration(id);
        return ResponseEntity.ok("You deleted one team from the database.");
    }
}