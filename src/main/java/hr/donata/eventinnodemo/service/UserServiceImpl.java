package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.entity.Registration;
import hr.donata.eventinnodemo.entity.User;
import hr.donata.eventinnodemo.mapper.UserMapper;
import hr.donata.eventinnodemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void create(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userRepository.save(user);

    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
