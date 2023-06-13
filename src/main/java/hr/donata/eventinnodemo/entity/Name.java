package hr.donata.eventinnodemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "name")
public class Name {
    @Id
    private Long id;

    @Column(name ="first")
    private String first;
    @Column(name ="last")
    private String last;




}