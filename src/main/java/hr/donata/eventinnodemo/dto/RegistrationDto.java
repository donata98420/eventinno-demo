package hr.donata.eventinnodemo.dto;

import lombok.Data;

import java.time.chrono.ChronoLocalDateTime;
import java.util.UUID;

@Data
public class RegistrationDto {
    private UUID uuid;
    private PersonalDto personal;
    private ExperienceDto experience;
    private String motivation;
    private String preferredOS;

    public ChronoLocalDateTime<?> getRegistrationsNotBefore() {

        return null;
    }

    public ChronoLocalDateTime<?> getRegistrationsNotAfter() {

        return null;
    }

    public void setUuid(UUID randomUUID) {
        this.uuid = randomUUID;
    }

    @Data
    public static class PersonalDto {
        private NameDto name;
        private String email;
        private String phone;
        private EducationDto education;
        private String summary;
    }

    @Data
    public static class NameDto {
        private String first;
        private String last;
    }

    @Data
    public static class EducationDto {
        private String faculty;
        private int year;
    }

    @Data
    public static class ExperienceDto {
        private int years;
        private String[] skills;
        private String repositoryUrl;
        private String summary;
    }
}