package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.entity.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{
    @Override
    public int calculateScore(Registration registration) {
        return 0;
    }
}
