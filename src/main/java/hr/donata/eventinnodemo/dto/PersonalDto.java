package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class PersonalDto {
    private NameDto name;
    private String email;
    private String phone;
    private EducationDto education;
    private String summary;

}
