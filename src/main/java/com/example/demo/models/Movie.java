package com.example.demo.models;

public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private String title;
    private String genre;
    private int popularity;
    private String award;

    public Movie(int year, int length, String title){
        this.year = year;
        this.length = length;
        this.title = title;
    }
    public Movie(int year, int length, String title, String genre, int popularity, String award){
        this.year = year;
        this.length = length;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.award = award;
    }

    public Movie (String title) {
        this.title = title;

    }
    public String getTitle(){
        return this.title;
    }

    public String gotAward() {
        return award;
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public int compareTo(Movie m){
        if (this.popularity > m.popularity){
            return -1;
        }
        else if (this.popularity < m.popularity){
            return 1;
        }
        else {
            return 0;
        }
    }
    @Override
    public String toString(){
        return "Title: " + title + ", Year: " + year + ", Length: " + length + "Genre, " + genre + "Popularity score: "
                + popularity + ", Awards: " + award;
    }
}


