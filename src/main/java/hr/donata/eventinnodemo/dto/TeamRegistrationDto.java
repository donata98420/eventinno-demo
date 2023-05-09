package hr.donata.eventinnodemo.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamRegistrationDto {

    private String name;
    private List<MentorDto> mentors;



}
