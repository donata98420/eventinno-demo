package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import hr.donata.eventinnodemo.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);
    Registration registrationDtoToRegistration(RegistrationDto registrationDto);

    default LocalDateTime mapChronoLocalDateTime(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime == null) {
            return null;
        }
        return LocalDateTime.from(chronoLocalDateTime);
    }

}
