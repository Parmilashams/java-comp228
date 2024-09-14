package exercise1;

import java.util.Date;

public class Singers {
    // declare Instance variables
    private int singerId;
    private String singerName;
    private String singerAddress;
    private Date dateOfBirth;
    private int albumsPublished;
    // for simplification I used string for date of birth

    // No-argument( default) constructor
    public Singers() {
        this.singerId = 0;
        this.singerName = "Unknown";
        this.singerAddress = "Unknown";
        this.dateOfBirth = new Date();
        this.albumsPublished = 0;
        //I used today's date by default
    }

    // 1-argument constructor
    public Singers(int singerId) {
        this();
        this.singerId = singerId;
    }

    // 2-argument constructor
    public Singers(int singerId, String singerName) {
        this(singerId);
        this.singerName = singerName;
    }

    // 3-argument constructor
    public Singers(int singerId, String singerName, String singerAddress) {
        this(singerId, singerName);
        this.singerAddress = singerAddress;
    }

    // 4-argument constructor
    public Singers(int singerId, String singerName, String singerAddress, Date dateOfBirth) {
        this(singerId, singerName, singerAddress);
        this.dateOfBirth = dateOfBirth;
    }

    // 5-argument constructor
    public Singers(int singerId, String singerName, String singerAddress, Date dateOfBirth, int albumsPublished) {
        this(singerId, singerName, singerAddress, dateOfBirth);
        this.albumsPublished = albumsPublished;

    }

    // Getters
    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSingerAddress() {
        return singerAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAlbumsPublished() {
        return albumsPublished;
    }

    // Setters
    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlbumsPublished(int albumsPublished) {
        this.albumsPublished = albumsPublished;
    }

    // Setter to set all values at once
    public void setAllValues(int singerId, String singerName, String singerAddress, Date dateOfBirth, int albumsPublished) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.albumsPublished = albumsPublished;
    }

    // Display method to print current values
    public void displaySingerInfo() {
        System.out.println("Singer ID: " + singerId);
        System.out.println("Singer Name: " + singerName);
        System.out.println("Singer Address: " + singerAddress);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Albums Published: " + albumsPublished);
    }
}
