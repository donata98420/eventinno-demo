package hr.donata.eventinnodemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private NameDto name;
    private String email;
    private String phone;
    private EducationDto education;
    private String summary;
    private int experienceYears;
    private List<String> skills;
    private String repositoryUrl;
    private String experienceSummary;
    private String motivation;
    private String preferredOS;
    private List<RegistrationDto> registrationList;

    public List<RegistrationDto> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<RegistrationDto> registrationList) {
        this.registrationList = registrationList;
    }
}