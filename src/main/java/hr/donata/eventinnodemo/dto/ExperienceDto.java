package hr.donata.eventinnodemo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ExperienceDto {

    private int years;
    private String[] skills;
    private String repositoryUrl;
    private String summary;

}
