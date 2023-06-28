package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.EducationDto;
import hr.donata.eventinnodemo.entity.Education;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);
    @Mapping(target = "id", source = "year")
    Education educationDtoToEducation(EducationDto educationDto);
}
