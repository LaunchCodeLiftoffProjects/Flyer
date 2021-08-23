package org.launchcode.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Concert {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "Must enter a band name")
    private String bandName;

    @NotEmpty(message = "Must enter a city")
    private String city;

    @NotEmpty(message = "Must enter a venue")
    private String venue;

    @NotEmpty(message = "Must enter a date")
    private String date;

    @NotEmpty(message = "Must enter a time")
    private String time;

    @NotEmpty(message = "Must enter a price")
    private String price;

    public Concert(int id, String bandName, String city, String venue, String date, String time, String price) {
        this.id = id;
        this.bandName = bandName;
        this.city = city;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Concert() {
    }

    public int getId() {
        return id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert that =(Concert) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return bandName + city;
    }
}
