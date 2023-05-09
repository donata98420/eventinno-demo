package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.TeamRegistrationDto;
import hr.donata.eventinnodemo.entity.TeamRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamRegistrationMapper {


    TeamRegistrationMapper INSTANCE = Mappers.getMapper(TeamRegistrationMapper.class);

    TeamRegistration teamRegistrationDtoToTeamRegistration(TeamRegistrationDto teamRegistrationDto);


}
