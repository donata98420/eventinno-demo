package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.service.MentorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
