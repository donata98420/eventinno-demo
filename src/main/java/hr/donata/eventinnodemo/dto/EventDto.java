package hr.donata.eventinnodemo.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {

    private String name;
    private Byte maxParticipants;
    private ZonedDateTime registrationsNotAfter;
    private ZonedDateTime confirmationNotAfter;
    private ZonedDateTime registrationsNotBefore;
    private LocalDate startDate;
    private Long weeks;
    private List<TeamRegistrationDto> teams;

}


