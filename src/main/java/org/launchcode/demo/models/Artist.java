package org.launchcode.demo.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Artist Name is required")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank(message = "instrument can not be empty")
    @Size (min = 1, max = 50)
    private String instrument;

    @NotBlank(message = "Genre can not be empty")
    @Size (min = 1, max = 50)
    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        Period period = Period.between(getBirthdate(),LocalDate.now());
        age = period.getYears();
        return age;
    }

    public Artist(int id, String name, String instrument, String genre, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.instrument = instrument;
        this.genre = genre;
        this.birthdate = birthdate;
        Period period = Period.between(birthdate,LocalDate.now());
        this.age = period.getYears();
    }

    public Artist(){

    }
}
