package hr.donata.eventinnodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Personal personal;

    @Embedded
    private Experience experience;

    private String motivation;
    private String preferredOS;


}

