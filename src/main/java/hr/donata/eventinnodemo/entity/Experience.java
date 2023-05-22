package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Experience {
    private int years;

    @ElementCollection
    @CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "skill")
    private List<String> skills;

    private String repositoryUrl;
    private String summary;


}
