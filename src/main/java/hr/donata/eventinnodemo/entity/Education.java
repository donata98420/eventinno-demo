package hr.donata.eventinnodemo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Education {
    private String faculty;
    private int year;


}
