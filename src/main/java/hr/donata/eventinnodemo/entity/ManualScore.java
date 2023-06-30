package hr.donata.eventinnodemo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class ManualScore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manualScore_sequence")
    @SequenceGenerator(name = "manualScore_sequence", allocationSize = 1)
    private Long id;
}
