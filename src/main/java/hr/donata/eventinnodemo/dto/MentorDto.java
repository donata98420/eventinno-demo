package hr.donata.eventinnodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MentorDto {
    private String email;
    private String team;

    public MentorDto(String email, String team) {
        this.email = email;
        this.team = team;
    }

}
