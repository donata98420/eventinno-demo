package hr.donata.eventinnodemo.dto;

import lombok.Data;

@Data
public class NameDto {
    private String first;
    private String last;
    private Long id;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}