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

        LocalDateTime notBeforeDateTime = LocalDateTime.of(2023, 6, 1, 0, 0); //
        return ChronoLocalDateTime.from(notBeforeDateTime);
    }

    public ChronoLocalDateTime<?> getRegistrationsNotAfter() {

        LocalDateTime notAfterDateTime = LocalDateTime.of(2023, 6, 30, 23, 59); //
        return ChronoLocalDateTime.from(notAfterDateTime);
    }



}