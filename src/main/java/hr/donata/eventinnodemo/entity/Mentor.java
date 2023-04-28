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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="email")
    private String email;
    @ManyToOne
    private TeamRegistration teamRegistration;



}
