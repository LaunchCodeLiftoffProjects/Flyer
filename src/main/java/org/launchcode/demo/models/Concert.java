package org.launchcode.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Concert {
    @Id
    @GeneratedValue
    private int id;

    private String bandName;

    private String city;

    private String venue;

    private String date;

    private String time;

    private String price;

    public Concert(String bandName, String city, String venue, String date, String time, String price) {
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
        Concert concert =(Concert) o;
        return id == concert.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return bandName + city;
    }
}
