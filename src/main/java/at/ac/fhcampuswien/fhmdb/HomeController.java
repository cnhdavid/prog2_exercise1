package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public JFXButton clearBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    //public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList(); // automatically updates corresponding UI elements when underlying data changes

    private final MovieAPI movieAPI = new MovieAPI();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initialize UI stuff
        genreComboBox.setPromptText("Select Genre");
        genreComboBox.getItems().addAll(Arrays.stream(Genre.MovieGenre.values()).map(Enum::name).collect(Collectors.toList()));

        try {
            List<Movie> movies = movieAPI.fetchMovies("", "");
            movieListView.setItems(FXCollections.observableArrayList(movies));
        } catch (IOException e) {
            e.printStackTrace();

        }

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {

                sortBtn.setText("Sort (desc)");
                sortMoviesAscending();
            } else {

                sortBtn.setText("Sort (asc)");
                sortMoviesDescending();
            }
        });
    }

    void sortMoviesAscending(List<Movie> unsortedMovies) {
        unsortedMovies.sort(Comparator.comparing(Movie::getTitle));
        System.out.println("Sorted Movies:");
        for (Movie movie : unsortedMovies) {
            System.out.println(movie);
        }

    }

    void sortMoviesDescending(List<Movie> unsortedMovies) {
        unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
        System.out.println("Sorted Movies:");
        for (Movie movie : unsortedMovies) {
            System.out.println(movie);
        }

    }

    private void sortMoviesAscending() {
        List<Movie> movieList = movieListView.getItems();
        movieList.sort(Comparator.comparing(Movie::getTitle));
        movieListView.setItems(FXCollections.observableArrayList(movieList));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    private void sortMoviesDescending() {
        List<Movie> movieList = movieListView.getItems();
        movieList.sort(Comparator.comparing(Movie::getTitle).reversed());
        movieListView.setItems(FXCollections.observableArrayList(movieList));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    @FXML
    private void filterMovies(ActionEvent event) throws IOException {
        String searchText = searchField.getText().trim().toLowerCase();
        String selectedGenre = (String) genreComboBox.getValue();

        try {
            List<Movie> filteredMovies = movieAPI.fetchMovies(searchText, selectedGenre);
            movieListView.setItems(FXCollections.observableArrayList(filteredMovies));
        } catch (IOException e) {
            e.printStackTrace();
            // Fehlerbehandlung...
        }
        // Filter movies based on search text and selected genre
        List<Movie> filteredMovies = movieAPI.fetchMovies(searchText, selectedGenre).stream()
                .filter(movie -> searchText.isEmpty() ||
                        movie.getTitle().toLowerCase().contains(searchText) ||
                        movie.getDescription().toLowerCase().contains(searchText))
                .filter(movie -> selectedGenre == null ||
                        movie.getGenres().contains(Genre.MovieGenre.valueOf(selectedGenre)))
                .collect(Collectors.toList());
        Reset();
        movieListView.setItems(FXCollections.observableArrayList(filteredMovies));
        movieListView.setCellFactory(movieListView -> new MovieCell());
        filteredMovies.clear();

    }

    @FXML
    private void clearFilters() {
        searchField.setText("");

        genreComboBox.getSelectionModel().clearSelection();

        movieListView.setItems(FXCollections.observableArrayList(movieAPI));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    public List<Movie> filterMovies(List<Movie> movies, String query) {
        // Use stream and filter to find movies that contain the query in their title
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void Reset() {
        movieListView.setItems(FXCollections.observableArrayList(movieAPI));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    public int getLongestMovieTitle(List<Movie> movies) {
        // Use streams to map each movie to its title length and find the maximum title length
        return movies.stream()
                .mapToInt(movie -> movie.getTitle().length())
                .max()
                .orElse(0); // Return 0 if the list of movies is empty
    }

    public String getMostPopularActor(List<Movie> movies) {
        // Use streams to flatMap the main cast of each movie and collect them into a single list
        List<String> allActors = movies.stream()
                .flatMap(movie -> movie.getMainCast().stream())
                .collect(Collectors.toList());

        // Use Collectors.groupingBy to count occurrences of each actor
        Map<String, Long> actorCountMap = allActors.stream()
                .collect(Collectors.groupingBy(
                        actor -> actor,
                        Collectors.counting()
                ));

        // Find the actor with the maximum occurrence count
        Optional<Map.Entry<String, Long>> mostPopularActorEntry = actorCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        // Return the most popular actor
        return mostPopularActorEntry.map(Map.Entry::getKey).orElse(null);
    }

    public long countMoviesFrom(List<Movie> movies, String director) {
        // Use streams to filter movies by the specified director and count them
        return movies.stream()
                .filter(movie -> movie.getDirector().equals(director))
                .count();
    }

    /*
    public static void main(String[] args) {
        // Create some sample movies
        List<Movie> movies = Movie.initializeMovies();

        // Create an instance of HomeController
        HomeController controller = new HomeController();

        // Call the getLongestMovieTitle method and print the result
        int longestTitleLength = controller.getLongestMovieTitle(movies);
        System.out.println("Longest movie title length: " + longestTitleLength);
    }

     */

    /*
    public List<Movie> filterMoviesByGenre(Genre.MovieGenre genre) {
        return allMovies.stream()
                .filter(movie -> movie.getGenres().contains(genre))
                .collect(Collectors.toList());
    }

     */

}
