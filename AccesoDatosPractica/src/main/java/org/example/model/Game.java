package org.example.model;

import java.sql.Date;

public class Game {

    private int id;
    private String name;
    private int genre;
    private int pegi;
    private String platform;
    private Date devStartDate;
    private Date releaseDate;
    private int subDeveloper;


    public Game(){

    }

    public Game(int id, String name, int genre, int pegi, String platform, Date devStartDate, Date releaseDate, int subDeveloper) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.pegi = pegi;
        this.platform = platform;
        this.devStartDate = devStartDate;
        this.releaseDate = releaseDate;
        this.subDeveloper = subDeveloper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Date getDevStartDate() {
        return devStartDate;
    }

    public void setDevStartDate(Date devStartDate) {
        this.devStartDate = devStartDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getSubDeveloper() {
        return subDeveloper;
    }

    public void setSubDeveloper(int subDeveloper) {
        this.subDeveloper = subDeveloper;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", pegi=" + pegi +
                ", platform='" + platform + '\'' +
                ", devStartDate=" + devStartDate +
                ", releaseDate=" + releaseDate +
                ", subDeveloper=" + subDeveloper +
                '}';
    }
}
