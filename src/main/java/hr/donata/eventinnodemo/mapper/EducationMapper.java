package hr.donata.eventinnodemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);
}
