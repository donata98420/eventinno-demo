package hr.donata.eventinnodemo.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class RegistrationDto {
    private UUID uuid;
    private Long id;
    private PersonalDto personal;
    private ExperienceDto experience;
    private String motivation;
    private String preferredOs;
}