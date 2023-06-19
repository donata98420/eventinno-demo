package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.ExperienceDto;
import hr.donata.eventinnodemo.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);
    Experience experienceDtoToExperience(ExperienceDto experienceDto);


}
