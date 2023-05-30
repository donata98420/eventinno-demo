package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

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

    //
    @Column(name ="registrationsNotAfter")
    private ZonedDateTime registrationsNotAfter;

    @Column(name ="confirmationNotAfter")
    private ZonedDateTime confirmationNotAfter;

    @Column(name ="registrationsNotBefore")
    private ZonedDateTime registrationsNotBefore;

    @Column(name ="startDate")
    private LocalDate startDate;

    @Column(name ="weeks")
    private Long weeks;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<TeamRegistration> teamRegistrationList;


}
