package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.service.MentorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;

    }

    @PostMapping(path = "/save")
    private ResponseEntity<MentorDto> saveMentor(@RequestBody MentorDto mentorDto) {
        mentorService.create(mentorDto);
        return ResponseEntity.ok(mentorDto);
    }
    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.ok("You deleted one mentor from the database.");
    }
}