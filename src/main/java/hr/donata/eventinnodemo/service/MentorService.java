package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.dto.MentorDto;

public interface MentorService {
    void deleteMentor(Long id);
    void create(MentorDto mentorDto);

}
