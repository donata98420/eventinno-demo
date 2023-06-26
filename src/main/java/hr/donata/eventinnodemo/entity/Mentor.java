package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mentor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_sequence")
    @SequenceGenerator(name = "mentor_sequence", allocationSize = 1)
    private Long id;

    @Column(name ="email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamRegistrationId")
    private TeamRegistration teamRegistration;



}
