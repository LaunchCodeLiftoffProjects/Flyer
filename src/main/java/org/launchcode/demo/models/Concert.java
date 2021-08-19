package org.launchcode.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

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

//    public List<Concert> getConcerts() {return concerts;}
//
//    public void setConcerts(List<Concert> concerts) {
//        this.concerts = concerts;
//    }
}
