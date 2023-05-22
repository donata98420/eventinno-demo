package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registrationDto) {
        registrationService.create(registrationDto);
        return ResponseEntity.ok(registrationDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("You deleted one registration from the database.");
    }

}
