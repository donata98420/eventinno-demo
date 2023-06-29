package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.entity.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        //  for education = 2 points
        int educationPoints = registration.getExperience().getEducationYears() * 2;
        score += educationPoints;

        // for experience = 5 points
        int experiencePoints = registration.getExperience().getExperienceYears() * 5;
        score += experiencePoints;

        // points for skills = 20 points for Java, Spring, SB
        // = other skills = Hibernate, JPA, Scala = 10 points
        score += calculateSkillsPoints(registration.getExperience().getSkills());

        // points for repository URL = 10 points
        if (registration.getExperience().getRepositoryUrl() != null) {
            score += 10;
        }

        return score;
    }

    private int calculateSkillsPoints(List<String> skills) {
    }




    }
}
