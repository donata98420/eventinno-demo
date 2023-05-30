package hr.donata.eventinnodemo.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RegistrationDto {
    private Long id;
    private UserDto user;
    private LocalDateTime registrationsNotBefore;
    private LocalDateTime registrationsNotAfter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public LocalDateTime getRegistrationsNotBefore() {
        
        return registrationsNotBefore;
    }

    public void setRegistrationsNotBefore(LocalDateTime registrationsNotBefore) {
        this.registrationsNotBefore = registrationsNotBefore;
    }

    public LocalDateTime getRegistrationsNotAfter() {
        return registrationsNotAfter;
    }

    public void setRegistrationsNotAfter(LocalDateTime registrationsNotAfter) {
        this.registrationsNotAfter = registrationsNotAfter;
    }
}