package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.ExperienceDto;
import hr.donata.eventinnodemo.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/save")
    public ResponseEntity<ExperienceDto> saveExperience(@RequestBody ExperienceDto experienceDto) {
        experienceService.create(experienceDto);
        return ResponseEntity.ok(experienceDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return ResponseEntity.ok("You deleted one experience from the database.");
    }

}
