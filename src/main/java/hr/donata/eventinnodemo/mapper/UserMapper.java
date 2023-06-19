package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.UserDto;
import hr.donata.eventinnodemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "registrationList[].registrationsNotBefore", expression = "java(formatDateTime(userDto.getRegistrationList().getRegistrationsNotBefore()))")
    User userDtoToUser(UserDto userDto);

    default String formatDateTime(ChronoLocalDateTime<?> dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return formatter.format(dateTime);
    }
}