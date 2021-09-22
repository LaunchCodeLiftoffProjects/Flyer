package org.launchcode.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PostMessage {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min=1, max=50, message = "Post name can not be blank")
    private String postName;

    @NotBlank
    @Size(min=1, max=250, message =" Post Text can not be blank")
    private String postText;

    @ManyToOne
    @NotNull(message = "Artist is required")
    Artist artist;

    public PostMessage(){}

    public PostMessage(String postName, String postText, Artist artist) {
        this.postName = postName;
        this.postText = postText;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
