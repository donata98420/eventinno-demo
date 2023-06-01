package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.entity.User;
import hr.donata.eventinnodemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserDto userDto) {
        Long userId = userDto.getId();
        if (userId != null && userRepository.existsById(userId)) {
            throw new RuntimeException("Sorry, already exists a user with the same ID.");
        }

        User user = new User();
        user.setId(userId); // Setting ID
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // relationship with education
        userRepository.findById(id).ifPresent(user -> {
            user.getEducation().clear();
            userRepository.save(user);
        });

        // Deleting user
        userRepository.deleteById(id);
    }
}