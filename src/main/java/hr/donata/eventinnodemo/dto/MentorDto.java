package hr.donata.eventinnodemo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorDto {
    private String email;
    private Long eventId;

    public Long getEventId() {

        return eventId;
    }

    public void setEventId(Long eventId) {

        this.eventId = eventId;
    }
}
