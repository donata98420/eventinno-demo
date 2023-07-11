package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.ManualScoreDto;
import hr.donata.eventinnodemo.entity.ManualScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManualScoreMapper {

    ManualScoreMapper INSTANCE = Mappers.getMapper(ManualScoreMapper.class);
    @Mapping(target = "id", ignore = true)
    ManualScore manualScoreDtoToManualScore(ManualScoreDto manualScoreDto);






}
