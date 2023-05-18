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
    private final MentorMapper mentorMapper;

    public MentorController(MentorService mentorService, MentorMapper mentorMapper) {

        this.mentorService = mentorService;
        this.mentorMapper = mentorMapper;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<MentorDto> saveMentor(@RequestBody MentorDto mentorDto) {
        mentorService.create(mentorDto);
        return ResponseEntity.ok(mentorDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.ok("You deleted one mentor from database.");
    }

}
