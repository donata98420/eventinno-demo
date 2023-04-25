package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.mapper.MentorMapper;
import hr.donata.eventinnodemo.repository.MentorRepository;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    public MentorServiceImpl(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }
}
