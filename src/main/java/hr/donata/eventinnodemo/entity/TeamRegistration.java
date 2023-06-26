package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamRegistration_sequence")
    @SequenceGenerator(name = "teamRegistration_sequence", allocationSize = 1)
    private Long id;

    @Column(name ="name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    private Event event;

    @OneToMany(mappedBy = "teamRegistration", cascade = {CascadeType.ALL})
    private List<Mentor> mentors;


}
