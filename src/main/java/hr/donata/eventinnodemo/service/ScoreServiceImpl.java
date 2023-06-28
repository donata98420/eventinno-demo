package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.entity.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{

    /*
    private final education
    private final experience
            ...
    */

    @Override
    public int calculateScore(Registration registration) {

        int score = 0;
        // .............

    }
}
