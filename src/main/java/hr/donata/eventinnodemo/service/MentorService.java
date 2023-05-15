package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;

import java.util.List;

public interface MentorService {


    void deleteMentor(Long id);

    void create(MentorDto mentorDto);
}
