package org.launchcode.demo.models;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany

    private List<Concert> concerts= new ArrayList<>();

    @NotBlank(message = "Artist Name is required")
    @Size(min = 1, max = 50)
    private String name;

    //TODO Change instrument to number of members, eventually (maybe) list band members w/ their instruments.
    @NotBlank(message = "instrument can not be empty")
    @Size (min = 1, max = 50)
    private String instrument;

    @NotBlank(message = "Genre can not be empty")
    @Size (min = 1, max = 50)
    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate estDate;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public LocalDate getEstDate() {
        return estDate;
    }

    public void setEstDate(LocalDate estDate) {
        this.estDate = estDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        Period period = Period.between(getEstDate(),LocalDate.now());
        age = period.getYears();
        return age;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public Artist(List<Concert> concerts, String name, String instrument, String genre, LocalDate estDate, int age) {
        this.concerts = concerts;
        this.name = name;
        this.instrument = instrument;
        this.genre = genre;
        this.estDate = estDate;
        this.age = age;
    }

    public Artist(){

    }
}
