package hr.donata.eventinnodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class TeamRegistrationDto {

    private String name;
    private Long event;
    private List<MentorDto> mentors;

    public TeamRegistrationDto(String name, Long event, List<MentorDto> mentors) {
        this.name = name;
        this.event = event;
        this.mentors = mentors;
    }
}
