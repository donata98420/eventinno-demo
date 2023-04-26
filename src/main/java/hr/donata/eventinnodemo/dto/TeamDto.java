package hr.donata.eventinnodemo.dto;

import hr.donata.eventinnodemo.entity.Mentor;
import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    private String name;
    private String event;
    private List<Mentor> mentorList;

}
