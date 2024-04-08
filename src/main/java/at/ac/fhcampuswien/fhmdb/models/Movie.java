package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre.MovieGenre> genres = new ArrayList<>();
    private List<String> mainCast;
    private int releaseYear;
    private double rating;

    public Movie(String title, String description, List<Genre.MovieGenre> genres, int releaseYear, double rating, List<String> mainCast) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.mainCast = mainCast;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie: " + title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre.MovieGenre> getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }


    public List<String> getMainCast() {
        return mainCast;
    }

    public Object getDirector() {
        return null;
    }
}