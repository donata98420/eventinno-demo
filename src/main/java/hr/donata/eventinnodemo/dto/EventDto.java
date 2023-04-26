package hr.donata.eventinnodemo.dto;

import hr.donata.eventinnodemo.entity.Team;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {

    private String name;
    private byte maxParticipants;
    private LocalDateTime registrationsNotAfter;
    private LocalDateTime confirmationNotAfter;
    private LocalDateTime startDate;
    private LocalDateTime weeks;
    private List<Team> teams;


}


