package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class PersonalDto {
    private RegistrationDto.NameDto name;
    private String email;
    private String phone;
    private RegistrationDto.EducationDto education;
    private String summary;


}
