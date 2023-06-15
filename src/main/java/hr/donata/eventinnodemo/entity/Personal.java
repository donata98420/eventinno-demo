package hr.donata.eventinnodemo.entity;

import hr.donata.eventinnodemo.dto.RegistrationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="personal")
@Getter
@Setter
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="email")
    private String email;
    @Column(name ="phone")
    private String phone;
    @Column(name ="education")
    private RegistrationDto.EducationDto education;
    @Column(name ="summary")
    private String summary;


}
