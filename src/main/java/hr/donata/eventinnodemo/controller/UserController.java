package hr.donata.eventinnodemo.controller;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("You deleted one user from the database.");
    }


}
