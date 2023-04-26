package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "team")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="event")
    private String event;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.ALL})
    private List<Mentor> mentorList;


}
