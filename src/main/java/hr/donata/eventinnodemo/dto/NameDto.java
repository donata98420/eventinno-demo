package hr.donata.eventinnodemo.dto;
import lombok.Data;

@Data
public class NameDto {
    private String firstName;
    private String lastName;
    private Long oib;


    public NameDto(String fullName) {
        String[] names = fullName.split(" ");
        if (names.length > 0) {
            this.firstName = names[0];
        }
        if (names.length > 1) {
            this.lastName = names[1];
        }
    }


}