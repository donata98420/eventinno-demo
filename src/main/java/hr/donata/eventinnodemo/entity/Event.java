package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
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
    private LocalDateTime registrationsNotAfter;
    @Column(name ="confirmationNotAfter")
    private LocalDateTime confirmationNotAfter;
    @Column(name ="startDate")
    private LocalDateTime startDate;
    @Column(name ="weeks")
    private LocalDateTime weeks;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<Team> teamsList;




}
