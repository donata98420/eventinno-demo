package hr.donata.eventinnodemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "name")
public class Name {

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

    @Column(name ="first")
    private String first;
    @Column(name ="last")
    private String last;

    public Long getOib() {
        return oib;
    }

    public void setOib(Long oib) {
        this.oib = oib;
    }

    private Long oib;

    @Id
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}