package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MentorMapper {

    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);

    @Mapping(source = "teamRegistrationId", target = "teamRegistration.id")
    Mentor mentorDtoToMentor(MentorDto mentorDto);


}
