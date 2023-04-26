package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.repository.MentorRepository;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;

    }
}
