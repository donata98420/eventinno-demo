package hr.donata.eventinnodemo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_sequence")
    @SequenceGenerator(name = "education_sequence", allocationSize = 1)
    private Long id;
    @Column(name ="faculty")
    private String faculty;
    @Column(name ="year")
    private int year;



}