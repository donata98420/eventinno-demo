package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="years")
    private int years;
    @Column(name ="skills")
    List<String> skills;
    @Column(name ="repositoryUrl")
    private String repositoryUrl;
    @Column(name ="summary")
    private String summary;

}
