package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);
    Event eventDtoToEvent(EventDto eventDto);
    @AfterMapping
    default void mapEventIdInUser(@MappingTarget Event event) {
        event.getTeamRegistrationList().forEach(team -> team.setEvent(event));
    }


}
