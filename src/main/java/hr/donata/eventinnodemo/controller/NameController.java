package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.EducationDto;
import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.service.NameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/name")
public class NameController {
    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<NameDto> saveName(@RequestBody NameDto nameDto) {
        nameService.create(nameDto);
        return ResponseEntity.ok(nameDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteName(@PathVariable Long id) {
        nameService.deleteName(id);
        return ResponseEntity.ok("You deleted one name from the database.");
    }
}
