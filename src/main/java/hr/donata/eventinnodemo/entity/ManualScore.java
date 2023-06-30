package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manual_score")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManualScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manualScore_sequence")
    @SequenceGenerator(name = "manualScore_sequence", allocationSize = 1)
    private Long id;

    @Column(name ="manualScore")
    private String manualScore;
    @Column(name ="comment")
    private String comment;


}
