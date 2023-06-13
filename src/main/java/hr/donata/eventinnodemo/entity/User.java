package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "userss")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Name name;

    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Education education;
    private String summary;

    private int experienceYears;
    @ElementCollection
    private List<String> skills;
    private String repositoryUrl;
    private String experienceSummary;
    private String motivation;
    private String preferredOS;


    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Registration> registrationList;


}