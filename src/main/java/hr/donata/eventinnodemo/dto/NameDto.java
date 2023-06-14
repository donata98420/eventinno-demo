package hr.donata.eventinnodemo.dto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NameDto {
    private String first;
    private String last;

}