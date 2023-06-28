package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class ExperienceDto {

    private int years;
    private String[] skills;
    private String repositoryUrl;
    private String summary;

}
