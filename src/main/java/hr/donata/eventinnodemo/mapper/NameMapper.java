package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.NameDto;
import hr.donata.eventinnodemo.entity.Name;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NameMapper {

    NameMapper INSTANCE = Mappers.getMapper(NameMapper.class);
    Name nameDtoToName(NameDto nameDto);
}
