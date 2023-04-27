package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;
    @Column(name ="maxParticipant")
    private byte maxParticipants;
    @Column(name ="registrationsNotAfter")
    private ZonedDateTime registrationsNotAfter;
    @Column(name ="confirmationNotAfter")
    private ZonedDateTime confirmationNotAfter;
    @Column(name ="startDate")
    private LocalDate startDate;

    @Column(name ="weeks")
    private Long weeks;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<TeamRegistration> teamRegistrationList;




}
