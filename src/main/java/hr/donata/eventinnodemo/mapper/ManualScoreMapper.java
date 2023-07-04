package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.entity.ManualScore;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManualScoreMapper {

    ManualScoreMapper INSTANCE = Mappers.getMapper(ManualScoreMapper.class);
    ManualScore manualScoreDtoToManualScore(ManualScore manualScore);


}
