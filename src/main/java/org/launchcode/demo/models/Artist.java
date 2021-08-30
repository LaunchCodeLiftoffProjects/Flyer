package org.launchcode.demo.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Artist Name is required")
    @Size(min = 1, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist(){

    }
}
