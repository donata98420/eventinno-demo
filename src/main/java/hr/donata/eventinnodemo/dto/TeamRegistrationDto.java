package hr.donata.eventinnodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRegistrationDto {

    private String name;
    private List<MentorDto> mentors;

}
