package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
