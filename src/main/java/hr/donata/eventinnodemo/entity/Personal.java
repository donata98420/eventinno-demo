package hr.donata.eventinnodemo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Personal {
    @Embedded
    private Name name;
    private String email;
    private String phone;

    @Embedded
    private Education education;
    private String summary;


}
