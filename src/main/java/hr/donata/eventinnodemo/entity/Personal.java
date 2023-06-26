package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="personal")
@Getter
@Setter
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_sequence")
    @SequenceGenerator(name = "personal_sequence", allocationSize = 1)
    private Long id;
    @Column(name ="email")
    private String email;
    @Column(name ="phone")
    private String phone;

    @Column(name ="summary")
    private String summary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id")
    private Education education;



}
