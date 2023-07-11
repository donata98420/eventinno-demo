package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class ManualScoreDto {

    private String score;
    private String comment;

    public boolean isAddition() {
        return score != null && score.equalsIgnoreCase("addition");
    }
}
