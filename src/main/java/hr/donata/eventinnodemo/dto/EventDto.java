package hr.donata.eventinnodemo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {

    private String name;
    private byte maxParticipants;
    private String teams;
    private LocalDateTime registrationsNotAfter;
    private LocalDateTime confirmationNotAfter;
    private LocalDateTime startDate;
    private LocalDateTime weeks;
    private Long mentorId;
    private List<Team> teamList;


}


