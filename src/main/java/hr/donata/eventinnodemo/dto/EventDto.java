package hr.donata.eventinnodemo.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {

    private String name;
    private Byte maxParticipants;
    private LocalDate registrationsNotAfter;
    private LocalDate confirmationNotAfter;
    private LocalDate registrationsNotBefore;
    private LocalDate startDate;
    private Long weeks;
    private List<TeamRegistrationDto> teams;

}


