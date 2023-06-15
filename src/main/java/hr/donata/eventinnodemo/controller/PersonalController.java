package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.ExperienceDto;
import hr.donata.eventinnodemo.dto.PersonalDto;
import hr.donata.eventinnodemo.service.PersonalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PersonalController {
    private final PersonalService personalService;
    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @PostMapping("/save")
    public ResponseEntity<ExperienceDto> savePersonal(@RequestBody PersonalDto personalDto) {
        personalService.create(personalDto);
        return ResponseEntity.ok(personalDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonal(@PathVariable Long id) {
        personalService.deletePersonal(id);
        return ResponseEntity.ok("You deleted one personal from the database.");
    }


}
