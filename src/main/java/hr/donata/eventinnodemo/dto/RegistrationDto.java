package hr.donata.eventinnodemo.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.UUID;

@Data
public class RegistrationDto {
    private UUID uuid;
    private Long id;
    private Long eventId;
    private PersonalDto personal;
    private ExperienceDto experience;
    private String motivation;
    private String preferredOS;

    public ChronoLocalDateTime<?> getRegistrationsNotBefore() {

        LocalDateTime notBeforeDateTime = LocalDateTime.of(2023, 6, 1, 0, 0); // Replace with your desired date and time
        return ChronoLocalDateTime.from(notBeforeDateTime);
    }

    public ChronoLocalDateTime<?> getRegistrationsNotAfter() {

        LocalDateTime notAfterDateTime = LocalDateTime.of(2023, 6, 30, 23, 59); // Replace with your desired date and time
        return ChronoLocalDateTime.from(notAfterDateTime);
    }

    public void setUuid(UUID randomUUID) {
        this.uuid = randomUUID;
    }


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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