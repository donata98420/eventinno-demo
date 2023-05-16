package hr.donata.eventinnodemo.dto;

import hr.donata.eventinnodemo.entity.Event;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamRegistrationDto {

    private String name;
    private List<MentorDto> mentors;
    private Event event;
    private Long eventId;



}
