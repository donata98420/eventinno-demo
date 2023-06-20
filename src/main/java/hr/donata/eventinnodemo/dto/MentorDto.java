package hr.donata.eventinnodemo.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {

    public MentorDto(String email) {
        this.email = email;
    }
    private String email;
    private Long teamRegistrationId;

}
