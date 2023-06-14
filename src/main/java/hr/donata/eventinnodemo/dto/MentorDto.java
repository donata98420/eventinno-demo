package hr.donata.eventinnodemo.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorDto {


    public MentorDto(String email) {
        this.email = email;
    }

    private String email;
    private Long teamRegistrationId;


}
