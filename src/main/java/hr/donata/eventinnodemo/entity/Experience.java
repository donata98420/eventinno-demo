package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "experience")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="years")
    private int years;
    @Column(name ="skills")
    private List<String> skills;
    @Column(name ="repositoryUrl")
    private String repositoryUrl;
    @Column(name ="summary")
    private String summary;

}
