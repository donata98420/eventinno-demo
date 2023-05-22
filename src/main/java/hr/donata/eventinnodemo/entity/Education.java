import jakarta.persistence.Embeddable;

@Embeddable
public class Education {

    private String faculty;
    private int year;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}