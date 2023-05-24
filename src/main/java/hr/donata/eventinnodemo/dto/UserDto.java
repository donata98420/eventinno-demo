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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EducationDto getEducation() {
        return education;
    }

    public void setEducation(EducationDto education) {
        this.education = education;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getExperienceSummary() {
        return experienceSummary;
    }

    public void setExperienceSummary(String experienceSummary) {
        this.experienceSummary = experienceSummary;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getPreferredOS() {
        return preferredOS;
    }

    public void setPreferredOS(String preferredOS) {
        this.preferredOS = preferredOS;
    }

    public List<RegistrationDto> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<RegistrationDto> registrationList) {
        this.registrationList = registrationList;
    }
}