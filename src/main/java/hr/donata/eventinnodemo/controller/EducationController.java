package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EducationDto;
import hr.donata.eventinnodemo.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<EducationDto> saveEducation(@RequestBody EducationDto educationDto) {
        educationService.create(educationDto);
        return ResponseEntity.ok(educationDto);
    }
    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.ok("You deleted one education from the database.");
    }
}
