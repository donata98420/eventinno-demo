package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class ManualScoreDto {

    private String score;
    private String comment;
    private int value;

    public boolean isAddition() {
        return score != null && score.equalsIgnoreCase("addition");
    }

    public int getValue() {
        return value;
    }
}
