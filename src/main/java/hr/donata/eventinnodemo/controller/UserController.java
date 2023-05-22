package hr.donata.eventinnodemo.controller;


import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/save")
    private ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return ResponseEntity.ok(userDto);
    }


}
