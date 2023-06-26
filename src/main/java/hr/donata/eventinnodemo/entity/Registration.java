package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID uuid;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private Experience experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id", referencedColumnName = "id")
    private Personal personal;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private Education education;

    @Column(name ="motivation")
    private String motivation;
    @Column(name ="preferredOs")
    private String preferredOs;




}
