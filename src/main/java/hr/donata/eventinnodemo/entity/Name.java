package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_sequence")
    @SequenceGenerator(name = "name_sequence", allocationSize = 1)
    private Long id;

    @Column(name ="first")
    private String first;
    @Column(name ="last")
    private String last;




}