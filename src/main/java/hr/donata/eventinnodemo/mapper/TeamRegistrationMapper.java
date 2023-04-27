package hr.donata.eventinnodemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamRegistrationMapper {


    TeamRegistrationMapper INSTANCE = Mappers.getMapper(TeamRegistrationMapper.class);
}
