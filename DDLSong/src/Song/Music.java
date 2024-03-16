/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Song;

/**
 *
 * @author joshuatupas
 */
public class Music {
    // declare variables with title and artist of the song
    private String title;
    private String artist;

    // Constructor twith title and artist
    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter and setter methods for the title and artist
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Returns a toString of the song
    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist;
    }
}
