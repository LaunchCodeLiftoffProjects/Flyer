package org.launchcode.demo.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.print.attribute.Size2DSyntax.MM;

@Entity
public class Concert {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message =  "BandName is required")
//    @Size(min=1, max=150)
//    private String bandName;

//    @NotBlank(message = "City is required")
//    @Size(min=1, max=50)
    private String city;

//    @NotBlank(message = "Venue is required")
//    @Size(min=1, max=150)
    private String venue;


//TODO Change formating of date MM-DD-YYYY
//    @NotBlank(message = "Concert Date is required")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private String date;

    //TODO time displaying 24hr instead of 12hr.
    @DateTimeFormat(pattern ="hh:mm a")
//   @NotBlank(message = "Concert Time is required")
//   @Size(min=1, max=50)
    private String time;

    @NotNull(message = "Price is required")
//    @Size(min=1, max=50)
    private float price;

    @ManyToOne
    private Artist artists;

    public Concert( String city, String venue, String date, String time, float price, Artist artists) {
//        this.bandName = bandName;
        this.city = city;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.price = price;
        this.artists = artists;
    }

    public Concert() {
    }

    public int getId() {
        return id;
    }

//    public String getBandName() {
//        return bandName;
//    }
//
//    public void setBandName(String bandName) {
//        this.bandName = bandName;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Artist getArtists() {
        return artists;
    }

    public void setArtists(Artist artists) {
        this.artists = artists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Float.compare(concert.price, price) == 0 &&
                city.equals(concert.city) && venue.equals(concert.venue) && date.equals(concert.date) && time.equals(concert.time) && artists.equals(concert.artists);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
