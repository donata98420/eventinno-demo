package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_sequence")
    @SequenceGenerator(name = "registration_sequence", allocationSize = 1)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID uuid;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private Experience experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id", referencedColumnName = "id")
    private Personal personal;

    @Column(name ="motivation")
    private String motivation;
    @Column(name ="preferredOs")
    private String preferredOs;

    @Column(name ="score")
    private int score;

    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL)
    private List<ManualScore> manualScores;

    public void setScore(int score) {
    }
    public void setManualScore(int manualScore) {
    }

}