package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.ExperienceDto;
import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.entity.Experience;
import hr.donata.eventinnodemo.entity.Name;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);
    Experience experienceDtoToExperience(ExperienceDto experienceDto);


}
