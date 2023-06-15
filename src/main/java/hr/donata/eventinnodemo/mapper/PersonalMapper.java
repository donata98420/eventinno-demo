package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.PersonalDto;
import hr.donata.eventinnodemo.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonalMapper {

    PersonalMapper INSTANCE = Mappers.getMapper(PersonalMapper.class);
    Personal personalDtoToPersonal(PersonalDto personalDto);
}
