package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;

public interface MentorService {

    void create(MentorDto mentorDto);
    void deleteMentor(Long id);
}
