package hr.donata.eventinnodemo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class EventDto {

    private String name;
    private byte maxParticipants;
    private ZonedDateTime registrationsNotAfter;
    private ZonedDateTime confirmationNotAfter;
    private LocalDate startDate;
    private Long weeks;
    private List<TeamRegistrationDto> teams;


}


