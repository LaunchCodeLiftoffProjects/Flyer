package org.launchcode.demo.models.dto;

import org.launchcode.demo.models.Artist;
import org.launchcode.demo.models.Concert;

import javax.validation.constraints.NotNull;

public class ConcertArtistDTO {
    @NotNull
    private Concert concert;

    @NotNull
    private Artist artist;

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ConcertArtistDTO(){}

    public ConcertArtistDTO(Concert concert, Artist artist) {
        this.concert = concert;
        this.artist = artist;
    }
}
