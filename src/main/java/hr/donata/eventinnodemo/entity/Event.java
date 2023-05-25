package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", unique = true)
    private String name;

    @Column(name ="maxParticipant")
    private Byte maxParticipants;

    @Column(name ="registrationsNotAfter")
    private LocalDateTime registrationsNotAfter;

    @Column(name ="confirmationNotAfter")
    private LocalDateTime confirmationNotAfter;

    @Column(name ="registrationsNotBefore")
    private LocalDateTime registrationsNotBefore;

    @Column(name ="startDate")
    private LocalDate startDate;

    @Column(name ="weeks")
    private Long weeks;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<TeamRegistration> teamRegistrationList;


}
