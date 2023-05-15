package hr.donata.eventinnodemo.mapper;

import hr.donata.eventinnodemo.dto.MentorDto;
import hr.donata.eventinnodemo.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MentorMapper {

    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);


    Mentor mentorDtoToMentor(MentorDto mentorDto);

    List<Mentor> mentorDtosToMentors(List<MentorDto> mentorDtos);
}
