package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.EventDto;
import hr.donata.eventinnodemo.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event eventDtoToEvent(EventDto eventDto);

}
