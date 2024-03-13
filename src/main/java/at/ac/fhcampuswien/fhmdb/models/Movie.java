package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres = new ArrayList<>();

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public enum Genre {
        ALL, ACTION, ADVENTURE, ANIMATION, BIOGRAPHY, COMEDY, CRIME, DRAMA,
        DOCUMENTARY, FAMILY, FANTASY, HISTORY, HORROR, MUSICAL, MYSTERY,
        ROMANCE, SCIENCE_FICTION, SPORT, THRILLER, WAR, WESTERN,
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    // Initialisierung der Movies
    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();

        // Movie 1
        Movie movie1 = new Movie("The Adventure Quest", "Join our heroes on an epic journey filled with danger, excitement, and  twists as they embark on the ultimate adventure quest to save the world.",
                List.of(Genre.ADVENTURE, Genre.FANTASY));
        movies.add(movie1);

        // Movie 2
        Movie movie2 = new Movie("Comedy Chaos", "Get ready for non-stop laughter in this hilarious comedy that follows the misadventures of a group of friends trying to navigate the ups and downs of life with a comedic twist.",
                List.of(Genre.COMEDY, Genre.ROMANCE));
        movies.add(movie2);

        // Movie 3
        Movie movie3 = new Movie("Mystery Mansion", "Step into the eerie world of Mystery Mansion, where dark secrets and enigmatic puzzles await. As the characters unfold the mystery, the suspense builds, keeping you on the edge of your seat.",
                List.of(Genre.MYSTERY, Genre.THRILLER));
        movies.add(movie3);

        // Movie 4
        Movie movie4 = new Movie("Sci-Fi Odyssey", "Embark on a mind-bending journey through time and space in this futuristic sci-fi odyssey. Immerse yourself in a world of advanced technology, alien encounters, and the endless possibilities of the cosmos.",
                List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE));
        movies.add(movie4);

        Movie movie5 = new Movie("The Wolf of Wall Street", "The Wolf of Wall Street is a high-octane biographical drama that follows the rise and fall of Jordan Belfort, a charismatic stockbroker who indulges in a hedonistic lifestyle of excess and corruption in the 1990s.",
                List.of(Genre.BIOGRAPHY, Genre.DRAMA));
        movies.add(movie5);

        Movie movie6 = new Movie("Titanic", "Titanic is a romantic drama that intertwines the tragic historical sinking of the RMS Titanic with a poignant love story between Jack, a penniless artist, and Rose, a wealthy young woman, set against the backdrop of the ill-fated maiden voyage.",
                List.of(Genre.ROMANCE, Genre.DRAMA));
        movies.add(movie6);


        return movies;

    }

}