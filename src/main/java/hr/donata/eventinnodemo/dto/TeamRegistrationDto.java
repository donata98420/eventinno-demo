package hr.donata.eventinnodemo.dto;

import hr.donata.eventinnodemo.entity.Event;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamRegistrationDto {
    private Long id;
    private String name;
    //
    private List<MentorDto> mentors = new ArrayList<>();
    private Event event;
    private Long eventId;



}
