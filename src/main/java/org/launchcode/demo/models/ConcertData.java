package org.launchcode.demo.models;

import java.util.ArrayList;
import java.util.Locale;

public class ConcertData {

    public static ArrayList<Concert> findByColumnAndValue(String column, String value, Iterable<Concert> allConcerts) {

        ArrayList<Concert> results = new ArrayList<>();

        if(value.toLowerCase().equals("all")){
            return (ArrayList<Concert>) allConcerts;
        }

        if(column.equals("all")){
            results = findByValue(value, allConcerts);
            return results;
        }
        for (Concert concert : allConcerts) {
            String aValue = getFieldValue(concert, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())){
                results.add(concert);
            }
        }

        return results;
    }

    public static String getFieldValue(Concert concert, String fieldName){
        String theValue;
        if (fieldName.equals("name")) {
            theValue = concert.getBandName();
        }else if (fieldName.equals("city")){
            theValue = concert.getCity().toString();
        } else {
            theValue = concert.getDate().toString();
        }

        return theValue;
    }

    public static ArrayList<Concert> findByValue(String value, Iterable<Concert> allConcerts) {
        String lower_val = value.toLowerCase();

        ArrayList<Concert> results = new ArrayList<>();

        for (Concert concerts : allConcerts) {

            if (concerts.getBandName().toLowerCase().contains(lower_val)) {
                results.add(concerts);
            } else if (concerts.getCity().toString().toLowerCase().contains(lower_val)){
                results.add(concerts);
            } else if (concerts.getDate().toString().toLowerCase().contains(lower_val)){
                results.add(concerts);
            } else if (concerts.toString().toLowerCase().contains(lower_val)) {
                results.add(concerts);
            }
        }

        return results;
    }
}
