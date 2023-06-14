package hr.donata.eventinnodemo.entity;

import jakarta.persistence.Column;

public class Experience {

    @Column(name ="years")
    private int years;
    @Column(name ="skills")
    private String[] skills;
    @Column(name ="repositoryUrl")
    private String repositoryUrl;
    @Column(name ="summary")
    private String summary;

}
