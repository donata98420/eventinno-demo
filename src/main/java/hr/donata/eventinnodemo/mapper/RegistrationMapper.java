package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);
    Registration registrationDtoToRegistration(RegistrationDto registrationDto);


}
