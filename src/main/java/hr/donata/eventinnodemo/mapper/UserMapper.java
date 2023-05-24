package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userDtoToUser(UserDto userDto);
}
