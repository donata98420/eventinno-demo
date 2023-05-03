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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name", unique = true)
    private String name;

    @ManyToOne
    private Event event;

    @OneToMany(mappedBy = "teamRegistration", cascade = {CascadeType.ALL})
    private List<Mentor> mentorList;

    public TeamRegistration getTeamRegistration() {

        return null;
    }


}
