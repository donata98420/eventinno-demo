package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.entity.User;
import hr.donata.eventinnodemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void create(UserDto userDto) {
        Long userId = userDto.getId();
        if (userId != null && userRepository.existsById(userId)) {
            throw new RuntimeException("Sorry, a user with the same ID already exists.");
        }

        User user = new User();
        user.setId(userId); // Setting ID
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        // Find the user by ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        // Clear the relationship with education
        user.getEducation().clear();
        userRepository.save(user);

        // Deleting user
        userRepository.deleteById(id);
    }
}