package hr.donata.eventinnodemo.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {

    private String name;
    private Byte maxParticipants;
    private LocalDateTime registrationsNotAfter;
    private LocalDateTime confirmationNotAfter;
    private LocalDateTime registrationsNotBefore;
    private LocalDate startDate;
    private Long weeks;
    private List<TeamRegistrationDto> teams;

}


