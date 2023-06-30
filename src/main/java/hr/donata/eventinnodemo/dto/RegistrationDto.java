package hr.donata.eventinnodemo.dto;

import hr.donata.eventinnodemo.entity.Education;
import hr.donata.eventinnodemo.entity.Event;
import lombok.Data;
import java.util.UUID;

@Data
public class RegistrationDto {
    private UUID uuid;
    private Long id;
    private String score;
    private PersonalDto personal;
    private ExperienceDto experience;
    private String motivation;
    private String preferredOs;

    private Education education;


}