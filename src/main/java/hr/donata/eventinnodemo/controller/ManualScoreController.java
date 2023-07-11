package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.service.ManualScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manualScore")
public class ManualScoreController {
    private final ManualScoreService manualScoreService;
    public ManualScoreController(ManualScoreService manualScoreService) {
        this.manualScoreService = manualScoreService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<ManualScoreDto> saveManualScore(@RequestBody ManualScoreDto manualScoreDto) {
        manualScoreService.create(manualScoreDto);
        return ResponseEntity.ok(manualScoreDto);
    }

}
