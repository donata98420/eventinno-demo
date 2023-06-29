package hr.donata.eventinnodemo.service;

import hr.donata.eventinnodemo.entity.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{
    private static final String[] JAVA_SKILLS = { "Java", "Spring", "Spring Boot" };
    private static final String[] OTHER_SKILLS = { "Hibernate", "JPA", "Scala" };

    @Override
    public int calculateScore(Registration registration) {
        int score = 0;
        // += for scoring incrementally

        // for education = 2 points
        int educationPoints = registration.getExperience().getEducationYears() * 2;
        score += educationPoints;

        // for experience = 5 points
        int experiencePoints = registration.getExperience().getYears() * 5;
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
        int points = 0;

        for (String skill : skills) {
            if (containsIgnoreCase(JAVA_SKILLS, skill)) {
                points += 20;
            } else if (containsIgnoreCase(OTHER_SKILLS, skill)) {
                points += 10;
            } else {
                points += 5;
            }
        }

        return points;
    }

    // if there exists a target value
    private boolean containsIgnoreCase(String[] array, String targetValue) {
        for (String value : array) {
            if (value.equalsIgnoreCase(targetValue)) {
                return true;
            }
        }
        return false;
    }
}