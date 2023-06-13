package hr.donata.eventinnodemo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name ="faculty")
    private String faculty;
    @Column(name ="year")
    private int year;

    public void clear() {
    }
}